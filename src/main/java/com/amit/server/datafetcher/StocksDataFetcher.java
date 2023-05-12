package com.amit.server.datafetcher;

import com.amit.server.types.Stock;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.util.Random;

@DgsComponent
public class StocksDataFetcher {

    @DgsSubscription
    public Publisher<Stock> stocks() {
        return Flux.generate(() -> Stock.newBuilder().name("NFLX").price((double) (500)).build(),
                (state, sink) -> {
                    Stock stock;
                    sink.next(stock = Stock.newBuilder().name("NFLX").price(state.getPrice() + new Random().nextDouble()).build());
//                    System.out.println("Generating stock ======> "+stock);
                    return stock;
                }
        );


//        return Flux.create( x -> Stock.newBuilder().name("NFLX").price( 500d+ new Random().nextDouble()).build(), FluxSink.OverflowStrategy.BUFFER);


//        return Flux.interval(Duration.ofSeconds(2)).map(
//                tick -> Stock.newBuilder().name("AMKU").price(1000d + tick).build()
//        )
//                .doOnError(x-> {
//                    System.out.println(" Ended Stream ");
//                });

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
