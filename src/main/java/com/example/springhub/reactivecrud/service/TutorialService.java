package com.example.springhub.reactivecrud.service;

import com.example.springhub.error.NoSuchUserException;
import com.example.springhub.reactivecrud.entity.Tutorial;
import com.example.springhub.reactivecrud.repository.TutorialReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class TutorialService implements ITutorialService{

    @Autowired
    TutorialReactiveRepository tutorialReactiveRepository;

    @Override
    public void create(Tutorial e) {
        tutorialReactiveRepository.save(e);
    }

    @Override
    public Mono<Tutorial> findById(UUID id) {
        return tutorialReactiveRepository.findById(id)
                .switchIfEmpty(Mono.error(new NoSuchUserException("No User Found.")));
    }

    @Override
    public Flux<Tutorial> findAll() {
        return tutorialReactiveRepository.findAll();
    }

    @Override
    public Mono<Tutorial> update(Tutorial e) {
        return tutorialReactiveRepository.save(e);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return tutorialReactiveRepository.deleteById(id);
    }
}
