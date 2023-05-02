package com.example.springhub.remote.product.webflux.service;

import com.example.springhub.reactive.entity.Tutorial;
import com.example.springhub.remote.product.webflux.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class EmployeeService {

    @Autowired
    WebClient webClient;

    public Mono<ServerResponse> getProducts(ServerRequest serverRequest) {
        Mono<Parent> parent = webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(Parent.class)
                .timeout(Duration.ofMillis(10_000));

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(parent, Tutorial.class);
    }
}
