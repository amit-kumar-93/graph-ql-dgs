package com.amit.dataloader;

import com.amit.service.DirectorServiceClient;
import com.amit.types.Director;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.BatchLoader;
import org.dataloader.Try;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@DgsComponent
public class DirectorDataLoaderViaLambda {
    @Autowired
    DirectorServiceClient directorServiceClient;

    @DgsDataLoader(name = "directorsViaLambda")
    public BatchLoader<String, List<Director>> directorBatchLoader =
            keys -> CompletableFuture.supplyAsync(() ->
                keys.stream()
                        .map(key -> Try.tryCall(() -> directorServiceClient.loadDirectorsList(keys)).get())
                        .collect(Collectors.toList()));
}
