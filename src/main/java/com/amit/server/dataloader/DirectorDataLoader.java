package com.amit.server.dataloader;

import com.amit.server.service.DirectorServiceClient;
import com.amit.server.types.Director;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.BatchLoader;
import org.dataloader.Try;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@DgsDataLoader(name = "directors")
public class DirectorDataLoader implements BatchLoader<String, Try<List<Director>>> {

    @Autowired
    DirectorServiceClient directorServiceClient;
/**
 * Simple Data Loader
 @Override public CompletionStage<List<Director>> load(List<String> keys) {
 return CompletableFuture.supplyAsync(()-> directorServiceClient.loadDirectors(keys));
 }
 */

    /**
     * Data Loader with {@link org.dataloader.Try}
     *
     * @param keys
     * @return List<T>
     */
    @Override
    public CompletionStage<List<Try<List<Director>>>> load(List<String> keys) {
        return CompletableFuture.supplyAsync(() ->
                keys.stream()
                        .map(key -> Try.tryCall(() -> directorServiceClient.loadDirectorsList(keys)))
                        .collect(Collectors.toList()));
    }
}
