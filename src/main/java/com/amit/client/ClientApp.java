package com.amit.client;

import com.netflix.graphql.dgs.client.GraphQLResponse;
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

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
@EnableWebFlux
public class ClientApp implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        WebClient webClient = WebClient.create("http://localhost:8080");
//        WebSocketClient webSocketClient = new TomcatWebSocketClient();
        ReactorNettyWebSocketClient reactorNettyWebSocketClient = new ReactorNettyWebSocketClient();
        WebSocketGraphQLClient client = new WebSocketGraphQLClient("ws://localhost:8080/subscriptions", reactorNettyWebSocketClient );//, webSocketClient, Duration.ofSeconds(100));


//        SSESubscriptionGraphQLClient client = new SSESubscriptionGraphQLClient("/subscriptions", webClient);
        Flux<GraphQLResponse> stocks = client.reactiveExecuteQuery("subscription { stocks { name price }}", Collections.emptyMap());

        stocks.delayElements(Duration.ofSeconds(1))
                .mapNotNull(r -> r.extractValue("data.stocks"))
                .log()
//                .take(10)
                .onErrorMap(Throwable::getCause)
                .subscribe();
    }
}
