package com.amit.server.dataloader.mapped;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorConfig {
    @Bean(name = "cachedThreadPoolBean")
    public Executor executor(){
        return Executors.newCachedThreadPool();
    }
}
