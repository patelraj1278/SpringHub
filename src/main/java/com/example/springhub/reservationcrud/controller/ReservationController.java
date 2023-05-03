package com.example.springhub.reservationcrud.controller;

import com.example.springhub.reservationcrud.entity.Reservation;
import com.example.springhub.reservationcrud.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/route/reservation")
public class ReservationController {

    @Autowired
    private RepositoryService repositoryService;

    @GetMapping(value="/getReservation",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Reservation>> getReservation(){
        return this.repositoryService.getReservation();
    }

    @GetMapping(value="/getReservationCacheEvict",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<HttpStatus> getReservationCacheEvict(){
        return this.repositoryService.getReservationCacheEvict();
    }

    @GetMapping(value="/getReservation/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Reservation> getReservationById(@PathVariable("id") UUID uuid){
        return this.repositoryService.getReservationById(uuid);
    }

    @PostMapping(value = "/addReservation",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Reservation> postReservation(@RequestBody Reservation reservation){
            return this.repositoryService.saveReservationData(reservation);
    }

}
