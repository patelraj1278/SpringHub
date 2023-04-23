package com.example.springhub.reservationdb.repository.controller;

import com.example.springhub.reservationdb.repository.ReservationRepository;
import com.example.springhub.reservationdb.repository.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationRepository reservationRepository;

    @GetMapping("/reservation/{id}")
    private ResponseEntity<Reservation> reservationFlux(@PathVariable("id") UUID uuid){
        Optional<Reservation> reservationData = this.reservationRepository.findById(uuid);
        if(reservationData.isPresent()){
            return new ResponseEntity<>(reservationData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(reservationData.get(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/addReservation",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Reservation> postReservation(@RequestBody Reservation reservation){
        Reservation _reservation = this.reservationRepository.save(new Reservation(UUID.randomUUID(),reservation.getName()));
        return new ResponseEntity<>(_reservation,HttpStatus.CREATED);
    }

}
