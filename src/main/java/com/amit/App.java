package com.amit;

import com.netflix.graphql.dgs.client.GraphQLResponse;
import com.netflix.graphql.dgs.client.SSESubscriptionGraphQLClient;
import com.netflix.graphql.dgs.client.WebSocketGraphQLClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import reactor.core.publisher.Flux;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        WebClient webClient = WebClient.create("http://localhost:8080");
//        WebSocketGraphQLClient client = new WebSocketGraphQLClient("ws://localhost:8080/subscriptions", new ReactorNettyWebSocketClient());

        SSESubscriptionGraphQLClient client = new SSESubscriptionGraphQLClient("/subscriptions", webClient);
        Flux<GraphQLResponse> stocks = client.reactiveExecuteQuery("subscription { stocks { name price }}", Collections.emptyMap());

        stocks
                .map(r -> r.extractValue("data.stocks"))
                .log()
                .subscribe();
    }
}
