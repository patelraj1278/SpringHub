/*
package com.example.springhub.reservationdb.controller;

import com.example.springhub.reservationdb.entity.Reservation;
import com.example.springhub.reservationdb.service.impl.RepositoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final RepositoryServiceImpl repositoryService;

    @GetMapping("/reservation/{id}")
    private ResponseEntity<Reservation> getReservation(@PathVariable("id") UUID uuid){
        return this.repositoryService.getReservationById(uuid);
    }

    @PostMapping(value = "/addReservation",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Reservation> postReservation(@RequestBody Reservation reservation){
            return this.repositoryService.saveReservationData(reservation);
    }

}
*/
