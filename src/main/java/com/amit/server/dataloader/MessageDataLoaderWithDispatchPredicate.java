//package com.amit.server.dataloader;
//
//import com.netflix.graphql.dgs.DgsDataLoader;
//import com.netflix.graphql.dgs.DgsDispatchPredicate;
//import org.dataloader.BatchLoader;
//import org.dataloader.registries.DispatchPredicate;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.CompletionStage;
//import java.util.stream.Collectors;
//
//@DgsDataLoader(name = "messagesWithScheduledDispatch")
//public class MessageDataLoaderWithDispatchPredicate implements BatchLoader<String, String> {
//    @DgsDispatchPredicate
//    DispatchPredicate pred = DispatchPredicate.dispatchIfLongerThan(Duration.ofSeconds(2));
//    @Override
//    public CompletionStage<List<String>> load(List<String> keys) {
//        return CompletableFuture.supplyAsync(() -> keys.stream().map(key -> "hello, " + key + "!").collect(Collectors.toList()));
//    }
//}