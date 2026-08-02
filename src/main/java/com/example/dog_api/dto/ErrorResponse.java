package com.example.dog_api.dto;

import lombok.Getter;
import lombok.Setter;

// Генерує getter-и.
@Getter

// Генерує setter-и.
@Setter
public class ErrorResponse {

    // Повідомлення про помилку.
    private String message;

}