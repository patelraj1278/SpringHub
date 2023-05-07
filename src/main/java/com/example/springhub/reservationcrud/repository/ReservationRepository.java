package com.example.springhub.reservationcrud.repository;

import com.example.springhub.reservationcrud.entity.Reservation;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends CassandraRepository<Reservation, UUID> {
    @AllowFiltering
    List<Reservation> findByName(String name);
}
