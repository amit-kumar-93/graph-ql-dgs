package com.amit.datafetcher;

import com.amit.types.Stock;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@DgsComponent
public class StocksDataFetcher {

    @DgsSubscription
    public Publisher<Stock> stocks() {
//        return Flux.generate(() -> Stock.newBuilder().name("NFLX").price((double) (500)).build(),
//                (state, sink) -> {
//                    Stock stock;
//                    sink.next(stock = Stock.newBuilder().name("NFLX").price(state.getPrice() + new Random().nextDouble()).build());
//                    return stock;
//                }
//        );

        return Flux.interval(Duration.ofSeconds(1)).map(
                tick -> Stock.newBuilder().name("AMKU").price(1000d + tick).build()
        )
                .doOnError(x-> {
                    System.out.println(" Ended Stream ");
                });

        //Below works with SSE but not with WS for longer than 10 seconds
//        return Flux.just(Stock.newBuilder().name("NFLX").price(500d).build()).repeat(100)
//                .delayElements(Duration.ofSeconds(1));
    }
//    @DgsData(parentType = DgsConstants.SHOW.TYPE_NAME, field = "directors")
//    public CompletableFuture<List<Director>> directors(DgsDataFetchingEnvironment dfe) {
//        DataLoader<String, List<Director>> dataloader = dfe.getDataLoader(DirectorsMappedDataLoader.class);
//        Show show = dfe.getSource();
//        return dataloader.load(show.getTitle());
//    }
}
