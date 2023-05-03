package com.example.springhub.reactivecrud.repository;

import com.example.springhub.reactivecrud.entity.Tutorial;
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
