package com.example.springhub.reactivecrud.service;

import com.example.springhub.reactivecrud.entity.Tutorial;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ITutorialService {
    void create(Tutorial e);

    Mono<Tutorial> findById(UUID id);

    Flux<Tutorial> findAll();

    Mono<Tutorial> update(Tutorial e);

    Mono<Void> delete(UUID id);
}
