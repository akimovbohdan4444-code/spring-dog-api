package com.example.dog_api.dto;

import lombok.Getter;
import lombok.Setter;

// Генерує getter-и.
@Getter

// Генерує setter-и.
@Setter
public class DogResponse {

    // ID собаки.
    private Long id;

    // Ім'я собаки.
    private String name;

    // Вік собаки.
    private int age;

}