package com.example.springhub.reservationdb.service.impl;

import com.example.springhub.reservationdb.entity.Reservation;
import com.example.springhub.reservationdb.repository.ReservationRepository;
import com.example.springhub.reservationdb.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RepositoryServiceImpl implements RepositoryService {

    private final ReservationRepository reservationRepository;

    @Override
    public ResponseEntity<List<Reservation>> getReservation() {
        List<Reservation> reservationData = this.reservationRepository.findAll();

        if(reservationData.size() > 0){
            return new ResponseEntity<>(reservationData, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(reservationData, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Reservation> getReservationById(UUID id){
        Optional<Reservation> reservationData = this.reservationRepository.findById(id);

        if(reservationData.isPresent()){
            return new ResponseEntity<>(reservationData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(reservationData.get(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Reservation> saveReservationData(Reservation reservation){
        Reservation _reservation = this.reservationRepository.save(new Reservation(UUID.randomUUID(),reservation.getName()));
        return new ResponseEntity<>(_reservation,HttpStatus.CREATED);
    }

}
