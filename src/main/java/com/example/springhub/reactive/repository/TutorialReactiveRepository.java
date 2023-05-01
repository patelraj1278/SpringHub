package com.example.springhub.reactive.repository;

import com.example.springhub.reactive.entity.Tutorial;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface TutorialReactiveRepository extends ReactiveCassandraRepository<Tutorial, UUID> {

    @AllowFiltering
    Flux<Tutorial> findByPublished(boolean published);
}
