package com.example.springhub.reservationdb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @PrimaryKey
    private UUID id;
    private String name;
}
