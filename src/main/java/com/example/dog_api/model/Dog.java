package com.example.dog_api.model;

// Entity означає:
// цей клас потрібно зберігати у базі.
import jakarta.persistence.Entity;

// Позначає головний ключ таблиці.
import jakarta.persistence.Id;

// Каже Hibernate автоматично
// генерувати id.
import jakarta.persistence.GeneratedValue;

// Тип генерації id.
import jakarta.persistence.GenerationType;

// Lombok.
import lombok.Getter;
import lombok.Setter;

// Генерує getter-и.
@Getter

// Генерує setter-и.
@Setter

// Робить клас Entity.
@Entity
public class Dog {

    // Первинний ключ.
    @Id

    // Hibernate сам створює id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ім'я собаки.
    private String name;

    // Вік.
    private int age;

}