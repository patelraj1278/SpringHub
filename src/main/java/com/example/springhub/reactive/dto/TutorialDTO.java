package com.example.springhub.reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialDTO {

    private UUID id;
    private String title;
    private String description;
    private boolean published;
}
