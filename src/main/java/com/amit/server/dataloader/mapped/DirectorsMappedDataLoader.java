package com.amit.server.dataloader.mapped;

import com.amit.server.service.DirectorServiceClient;
import com.amit.server.types.Director;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.MappedBatchLoader;
import org.dataloader.Try;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@DgsComponent
public class DirectorsMappedDataLoader {
    @Autowired
//    @Qualifier("cachedThreadPoolBean") // Use when Common Thread Pool is not to be used. Cached Threads re-use existing threads
    private Executor executor;

    @Autowired
    DirectorServiceClient directorServiceClient;

//    @DgsDataLoader(name = "directorsMappedDataLoaderLambda")
//    public MappedBatchLoader<String, List<Director>> mappedBatchLoader =
//           keys -> CompletableFuture.supplyAsync(() -> keys.stream()
//                   .map(key -> Try.tryCall(() -> directorServiceClient.loadDirectorsMapped(key)))
//                   .map( x-> x.get())
//                   .reduce((m1,m2)-> {m1.putAll(m2); return m1;}).get());

    @DgsDataLoader(name = "directorsMappedDataLoaderLambda", maxBatchSize = 10)
    public MappedBatchLoader<String, List<Director>> mappedBatchLoader =
            keys -> CompletableFuture.supplyAsync(() ->
                    Try.tryCall(()->
                            directorServiceClient.loadDirectors(new ArrayList<>(keys))
                    ).get()
            , executor);

}
