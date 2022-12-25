package com.example.paymentService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableAsync
public class BeanConfiguration {

    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

}
