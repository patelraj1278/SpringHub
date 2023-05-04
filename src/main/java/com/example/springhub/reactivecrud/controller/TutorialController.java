package com.example.springhub.reactivecrud.controller;

import com.example.springhub.error.NoSuchUserException;
import com.example.springhub.reactivecrud.entity.Tutorial;
import com.example.springhub.reactivecrud.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/nonroute/tutorial")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @RequestMapping(value = { "/create"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Tutorial e) {
        tutorialService.create(e);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Mono<Tutorial>> findById(@PathVariable("id") String id) {
        Mono<Tutorial> e = tutorialService.findById(UUID.fromString(id));
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tutorial> findAll() {
        Flux<Tutorial> emps = tutorialService.findAll();
        return emps;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Tutorial> update(@RequestBody Tutorial e) {
        return tutorialService.update(e);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        tutorialService.delete(UUID.fromString(id)).subscribe();
    }

}
