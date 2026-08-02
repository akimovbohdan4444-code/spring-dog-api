package com.example.dog_api.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

// Генерує getter-и.
@Getter

// Генерує setter-и.
@Setter
public class DogRequest {

    // Ім'я не може бути порожнім.
    @NotBlank(message = "Dog name cannot be empty")
    // Ім'я собаки.
    private String name;

    // Вік повинен бути не менше 1.
    @Min(
            value = 1,
            message = "Age must be greater than 0"
    )
    // Вік собаки.
    private int age;

}