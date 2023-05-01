/*
package com.example.springhub.reservationdb.controller;

import com.example.springhub.reservationdb.entity.Reservation;
import com.example.springhub.reservationdb.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final RepositoryService repositoryService;

    @GetMapping("/getReservation/{id}")
    private ResponseEntity<Reservation> getReservation(@PathVariable("id") UUID uuid){
        return this.repositoryService.getReservationById(uuid);
    }

    @PostMapping(value = "/addReservation",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Reservation> postReservation(@RequestBody Reservation reservation){
            return this.repositoryService.saveReservationData(reservation);
    }

}
*/
