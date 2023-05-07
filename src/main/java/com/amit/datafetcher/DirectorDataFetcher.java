package com.amit.datafetcher;

import com.amit.types.Stock;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsSubscription;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.time.Duration;

@DgsComponent
public class DirectorDataFetcher {

    @DgsSubscription(field = "stocks")
    public Publisher<Stock> stocks() {
        return Flux.interval(Duration.ofSeconds(0),Duration.ofSeconds(1))
                        .map( t -> Stock.newBuilder().name("NFLX").price(Double.valueOf(500+t)).build());
    }
}
