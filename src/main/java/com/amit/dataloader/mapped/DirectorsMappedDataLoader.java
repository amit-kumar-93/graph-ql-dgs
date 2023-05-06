package com.amit.dataloader.mapped;

import com.amit.service.DirectorServiceClient;
import com.amit.types.Director;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.MappedBatchLoader;
import org.dataloader.Try;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

@DgsComponent
public class DirectorsMappedDataLoader {
    @Autowired
    private DirectorServiceClient directorServiceClient;

    @DgsDataLoader(name = "directorsMappedDataLoaderLambda")
    public MappedBatchLoader<String, Try<Director>> mappedBatchLoader =
            keys -> CompletableFuture.supplyAsync(
                    () -> keys.stream().
                            map(
                                    key -> Try.tryCall(
                                            () -> directorServiceClient.loadDirector(keys))
                            )
                            .collect(Collectors.toMap(x->(x.get()).getName(), Function.identity() , (existing, newOne) -> existing)));

}
