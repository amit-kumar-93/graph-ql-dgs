package com.amit;

import com.amit.datafetcher.StocksDataFetcher;
import com.amit.types.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.autoconfig.DgsAutoConfiguration;
import graphql.ExecutionResult;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {DgsAutoConfiguration.class, StocksDataFetcher.class})
class SubscriptionDataFetcherTest {

    @Autowired
    DgsQueryExecutor queryExecutor;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void stocks() {
        ExecutionResult executionResult = queryExecutor.execute("subscription Stocks { stocks { name, price } }");
        Publisher<ExecutionResult> publisher = executionResult.getData();

        VirtualTimeScheduler virtualTimeScheduler = VirtualTimeScheduler.create();
        StepVerifier.withVirtualTime(() -> publisher, 3)
                .expectSubscription()
                .thenRequest(3)
                .assertNext(result -> assertThat(toStock(result).getPrice()).isEqualTo(500))
                .assertNext(result -> assertThat(toStock(result).getPrice()).isEqualTo(501))
                .assertNext(result -> assertThat(toStock(result).getPrice()).isEqualTo(502))
                .thenCancel()
                .verify();
    }

    private Stock toStock(ExecutionResult result) {
        Map<String, Object> data = result.getData();
        return objectMapper.convertValue(data.get("stocks"), Stock.class);
    }
}