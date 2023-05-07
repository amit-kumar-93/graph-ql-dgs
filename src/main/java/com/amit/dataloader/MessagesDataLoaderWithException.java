package com.amit.dataloader;

import com.amit.context.MyContext;
import com.netflix.graphql.dgs.DgsDataLoader;
import com.netflix.graphql.dgs.context.DgsContext;
import org.dataloader.BatchLoaderEnvironment;
import org.dataloader.BatchLoaderWithContext;
import org.dataloader.Try;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@DgsDataLoader(name = "messagesDataLoaderWithException")
public class MessagesDataLoaderWithException implements BatchLoaderWithContext<String, Try<String>> {
    @Override
    public CompletionStage<List<Try<String>>> load(List<String> keys, BatchLoaderEnvironment environment) {
        MyContext context = DgsContext.getCustomContext(environment);
        return CompletableFuture.supplyAsync(() -> keys.stream()
                .map(key -> Try.tryCall(() -> {
                    if (key.equals("A")) {
                        throw new RuntimeException("Invalid key");
                    }
                    return  context.getCustomState() + " " + key;
                })).collect(Collectors.toList()));
    }
}