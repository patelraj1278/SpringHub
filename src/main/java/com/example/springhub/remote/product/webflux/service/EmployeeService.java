package com.example.springhub.remote.product.webflux.service;

import com.example.springhub.remote.product.webflux.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    WebClient webClient;

    @Override
    public Flux<Parent> findAll() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Parent.class)
                .timeout(Duration.ofMillis(10_000));
    }
}
