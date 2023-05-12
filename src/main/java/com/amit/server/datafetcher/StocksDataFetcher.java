package com.amit.server.datafetcher;

import com.amit.server.types.Stock;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Random;

@DgsComponent
public class StocksDataFetcher {

    @DgsSubscription
    public Publisher<Stock> stocks() {
        return Flux.generate(() -> Stock.newBuilder().name("NFLX").price((double) (500)).build(),
                (state, sink) -> {
                    Stock stock;
                    sink.next(stock = Stock.newBuilder().name("NFLX").price(state.getPrice() + new Random().nextDouble()).build());
                    return stock;
                }
        );
    }
}
