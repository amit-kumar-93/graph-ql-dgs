package com.amit.service;

import com.amit.types.Director;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DirectorServiceClient {
    private List<Director> directorList = Arrays.asList(
            Director.newBuilder().name("George Douglas").showsDirected(17).rating(8).build(),
            Director.newBuilder().name("Sherway Gardener").showsDirected(17).rating(8).build(),
            Director.newBuilder().name("Gooey Trump").showsDirected(17).rating(8).build(),
            Director.newBuilder().name("David Warner Bros.").showsDirected(17).rating(8).build()
    );

    /** Simple DataLoader loader service impl
     * public List<Director> loadDirectors(List<String> keys) {
     * return directorList.stream()
     * .filter(
     * director -> keys.stream()
     * .anyMatch(k -> director.getName().startsWith(k)))
     * .distinct()
     * .collect(Collectors.toList());
     * }
     */

    public List<Director> loadDirectors(List<String> keys) {
        return directorList.stream()
                .filter(
                        director -> keys.stream()
                                .anyMatch(k -> director.getName().startsWith(k)))
                .distinct()
                .collect(Collectors.toList());
    }

    public Director loadDirector(List<String> keys) {
        return directorList.stream()
                .filter(
                        director -> keys.stream()
                                .anyMatch(k -> director.getName().startsWith(k)))
                .findFirst().get();
    }


    /**
     * Mapped Data Loader uses signature load(Set<T> keys) to map instead of List<T> keys
     * @param keys
     * @return com.amit.Director
     */
    public Director loadDirector(Set<String> keys) {
        return directorList.stream()
                .filter(
                        director -> keys.stream()
                                .anyMatch(k -> director.getName().startsWith(k)))
                .findFirst().get();
    }

//    public Director loadDirectors(String key) {
//        return directorList.stream()
//                .filter(
//                        director ->  director.getName().startsWith(key))
//                .findAny().get();
//    }
}
