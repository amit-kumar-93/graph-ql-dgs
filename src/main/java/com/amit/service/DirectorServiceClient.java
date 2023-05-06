package com.amit.service;

import com.amit.types.Director;
import com.netflix.graphql.dgs.DgsData;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Data
public class DirectorServiceClient {
    @Autowired
    ShowService showService;


    private final Map<String, List<Director>> showToDirectorMap = new HashMap<>();

    @PostConstruct
    private void populateShowsToDirectorMap() {
        List<Director> directorOzark = Arrays.asList(
                Director.newBuilder().name("George Douglas").showsDirected(17).rating(8).build(),
                Director.newBuilder().name("David Warner Bros.").showsDirected(12).rating(9).build()
        );

        List<Director> directorsStrangerThings = Arrays.asList(
                Director.newBuilder().name("Sherway Gardener").showsDirected(11).rating(8).build(),
                Director.newBuilder().name("Gooey Trump").showsDirected(5).rating(4).build()
        );

        List<Director> directorsMilano = Arrays.asList(
                Director.newBuilder().name("Gooey Trump").showsDirected(5).rating(4).build()
        );
        showToDirectorMap.put("Ozarks", directorOzark);
        showToDirectorMap.put("Stranger Things", directorsStrangerThings);
        showToDirectorMap.put("Milano", directorsMilano);
    }

    /**
     * Simple DataLoader loader service impl
     * public List<Director> loadDirectors(List<String> keys) {
     * return directorList.stream()
     * .filter(
     * director -> keys.stream()
     * .anyMatch(k -> director.getName().startsWith(k)))
     * .distinct()
     * .collect(Collectors.toList());
     * }
     */

    @SneakyThrows
    public Map<String, List<Director>> loadDirectors(List<String> keys) {
        System.out.println(Thread.currentThread().getName());
        return showToDirectorMap.entrySet()
                .stream()
                .filter(entry -> keys.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, newOne) -> old));
    }

    public List<Director> loadDirectorsList(List<String> keys) {
        Optional<Map.Entry<String, List<Director>>> entry = showToDirectorMap.entrySet().stream().filter(e -> keys.contains(e.getKey())).findFirst();
        return entry.map(Map.Entry::getValue).orElse(null);
    }

}
