package com.example.springhub.reservationcrud.service.impl;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.springhub.reservationcrud.entity.Reservation;
import com.example.springhub.reservationcrud.repository.ReservationRepository;
import com.example.springhub.reservationcrud.service.RepositoryService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RepositoryServiceImpl implements RepositoryService {

    Logger logger = LoggerFactory.getLogger(RepositoryServiceImpl.class);
    private final ReservationRepository reservationRepository;

    @Cacheable("reservationData")
    @Override
    public ResponseEntity<List<Reservation>> getReservation() {
        List<Reservation> reservationData = this.reservationRepository.findAll();
        logger.info("Inside reservationData....");
        if(reservationData.size() > 0){
            return new ResponseEntity<>(reservationData, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(reservationData, HttpStatus.NOT_FOUND);
        }
    }

    @Caching(evict = {@CacheEvict(value="reservationData", allEntries=true)})
    @Override
    public ResponseEntity<HttpStatus> getReservationCacheEvict() {
        logger.info("Inside reservationData Cache Evict....");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Reservation> getReservationById(UUID id){
        Optional<Reservation> reservationData = this.reservationRepository.findById(id);

        if(reservationData.isPresent()){
            return new ResponseEntity<>(reservationData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(reservationData.get(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Reservation> saveReservationData(Reservation reservation){
        reservation.setId(Uuids.timeBased());
        Reservation _reservation = this.reservationRepository.save(reservation);
        return new ResponseEntity<>(_reservation,HttpStatus.CREATED);
    }

    public ResponseEntity<List<Reservation>> getReservationByName(String name){
        List<Reservation> reservationData = this.reservationRepository.findByName(name);

        if(reservationData.size() > 0){
            return new ResponseEntity<>(reservationData, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(reservationData, HttpStatus.NOT_FOUND);
        }
    }

}
