package com.amit.client;

import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.netflix.graphql.dgs.client.SSESubscriptionGraphQLClient;
import com.netflix.graphql.dgs.client.WebSocketGraphQLClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Collections;

@SpringBootApplication
public class ClientApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        WebClient webClient = WebClient.create("http://localhost:8080");
        SSESubscriptionGraphQLClient client = new SSESubscriptionGraphQLClient("/subscriptions", webClient);
        Flux<GraphQLResponse> stocks = client.reactiveExecuteQuery("subscription { stocks { name price }}", Collections.emptyMap());

        stocks
                .mapNotNull(r -> r.extractValue("data.stocks"))
                .log()
                .onErrorMap(Throwable::getCause)
                .subscribe();
    }
}
