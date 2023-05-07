package com.example.springhub.reservationcrud.service;

import com.example.springhub.reservationcrud.entity.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface RepositoryService {

    ResponseEntity<List<Reservation>> getReservation();

    ResponseEntity<HttpStatus> getReservationCacheEvict();

    ResponseEntity<Reservation> getReservationById(UUID id);

    ResponseEntity<Reservation> saveReservationData(Reservation reservation);

    ResponseEntity<List<Reservation>> getReservationByName(String name);

}
