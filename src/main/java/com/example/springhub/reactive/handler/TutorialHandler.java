package com.example.springhub.reactive.handler;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.springhub.reactive.dto.TutorialDTO;
import com.example.springhub.reactive.entity.Tutorial;
import com.example.springhub.reactive.repository.TutorialReactiveRepository;
import com.example.springhub.reactive.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class TutorialHandler {

    @Autowired
    TutorialReactiveRepository tutorialReactiveRepository;

    public Mono<ServerResponse> getTutorialList(ServerRequest serverRequest){
        Flux<Tutorial> tutorialFlux = tutorialReactiveRepository.findAll();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(tutorialFlux,Tutorial.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getTutorialListById(ServerRequest serverRequest){
        Mono<Tutorial> tutorialMono = tutorialReactiveRepository.findById(UUID.fromString(serverRequest.pathVariable("id")));
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(tutorialMono,Tutorial.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findByPublished(ServerRequest serverRequest){
        Flux<Tutorial> tutorialFlux = tutorialReactiveRepository.findByPublished(true);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(tutorialFlux,Tutorial.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> saveTutorials(ServerRequest serverRequest){
        Mono<TutorialDTO> tutorialMono = serverRequest
                .bodyToMono(TutorialDTO.class)
                .map(ModelMapperUtil::tutorialDtoToTutorial)
                .doOnNext(x->x.setId(Uuids.timeBased()))
                .flatMap(tutorialReactiveRepository::save)
                .map(ModelMapperUtil::tutorialToTutorialDto);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(tutorialMono, TutorialDTO.class);
    }


    public Mono<ServerResponse> updateUserById(ServerRequest serverRequest) {

        Mono<TutorialDTO> tutorialMono = serverRequest
                .bodyToMono(TutorialDTO.class)
                .map(ModelMapperUtil::tutorialDtoToTutorial)
                .doOnNext(x->x.setId(UUID.fromString(serverRequest.pathVariable("id"))))
                .flatMap(tutorialReactiveRepository::save)
                .map(ModelMapperUtil::tutorialToTutorialDto);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(tutorialMono, Tutorial.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
