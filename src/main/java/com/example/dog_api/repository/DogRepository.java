package com.example.dog_api.repository;

// Імпортуємо модель Dog.
import com.example.dog_api.model.Dog;

// Імпортуємо JpaRepository.
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Це інтерфейс.
public interface DogRepository extends JpaRepository<Dog, Long> {

    // Знайти собак за ім'ям.
    List<Dog> findByName(String name);

    // Повертає собак,
// вік яких більший за age.
    List<Dog> findByAgeGreaterThan(int age);

}