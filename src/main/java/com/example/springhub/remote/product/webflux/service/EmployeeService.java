package com.example.springhub.remote.product.webflux.service;

import com.example.springhub.reactive.entity.Tutorial;
import com.example.springhub.remote.product.webflux.model.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    WebClient webClient;

    @Cacheable(value = "products")
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

    @CachePut(value = "products")
    public Mono<ServerResponse> getProductsCachePut(ServerRequest serverRequest) {
        Mono<Parent> parent = webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(Parent.class)
                .timeout(Duration.ofMillis(10_000));

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(parent, Tutorial.class);
    }

    @CacheEvict(value="products", allEntries=true)
    public Mono<ServerResponse> removeGetProductsCache(ServerRequest serverRequest){
        logger.info("Cache Evict Called for Products");
        logger.info("Cache Removed move");
        return ServerResponse.ok().build();
    }
}
