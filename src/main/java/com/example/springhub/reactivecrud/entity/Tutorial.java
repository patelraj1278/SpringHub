package com.example.springhub.reactivecrud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tutorial {
    @PrimaryKey
    private UUID id;
    private String title;
    private String description;
    private boolean published;
}
