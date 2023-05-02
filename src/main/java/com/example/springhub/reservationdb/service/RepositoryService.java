package com.example.springhub.reservationdb.service;

import com.example.springhub.reservationdb.entity.Reservation;
import com.example.springhub.reservationdb.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface RepositoryService {

    ResponseEntity<List<Reservation>> getReservation();

    ResponseEntity<Reservation> getReservationById(UUID id);

    ResponseEntity<Reservation> saveReservationData(Reservation reservation);

}
