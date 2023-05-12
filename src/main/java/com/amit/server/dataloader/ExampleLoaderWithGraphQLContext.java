package com.amit.server.dataloader;

import com.netflix.graphql.dgs.DgsDataLoader;
import graphql.GraphQLContext;
import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.BatchLoaderWithContext;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Collectors;

@DgsDataLoader(name = "exampleLoaderWithGraphQLContext")
public class ExampleLoaderWithGraphQLContext implements BatchLoaderWithContext<String, String> {
    @Override                                                                                                                             
    public CompletionStage<List<String>> load(List<String> keys, BatchLoaderEnvironment environment) {

        GraphQLContext graphQLContext = environment.getContext();
        return CompletableFuture.supplyAsync(() -> keys.stream().map((Function<String,String>) graphQLContext::get).collect(Collectors.toList()));
    }
}