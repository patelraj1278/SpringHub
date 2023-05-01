/*
package com.example.springhub.remote.product.service;

import com.example.springhub.remote.product.model.Employee;
import com.example.springhub.remote.product.model.Parent;
import com.example.springhub.remote.product.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Override
    public Mono<Products> findById(Integer id) {
        Mono<Products> parentObj = webClient.get()
                .uri("/products/")
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Products.class);

        return parentObj.filter(x->x.getId() == id);
    }
}
*/
