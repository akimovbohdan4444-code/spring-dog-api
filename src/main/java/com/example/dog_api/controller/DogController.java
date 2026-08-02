package com.example.dog_api.controller;

// Імпортуємо модель Dog.

import com.example.dog_api.mapper.DogMapper;
import com.example.dog_api.model.Dog;
// Optional використовується,
// коли об'єкт може існувати або ні.
import java.util.ArrayList;
import java.util.Optional;
// Імпортуємо Service.
import com.example.dog_api.service.DogService;
// DTO.
import com.example.dog_api.dto.DogRequest;
import com.example.dog_api.dto.DogResponse;
// Імпортуємо анотації Spring.
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
// Імпортуємо RequestBody.
import lombok.RequiredArgsConstructor;
// Імпортуємо PostMapping.

import java.util.List;

// Кажемо Spring, що це REST Controller.
@RequiredArgsConstructor
@RestController
public class DogController {

    // Mapper.
    private final DogMapper dogMapper;
    // Поле класу.
    private final DogService dogService;

    // Обробляємо GET-запит.
    @GetMapping("/dog")
    public Dog getDog() {
        // Просимо Service знайти собаку.
        return dogService.getDog();
    }

    @PostMapping("/dog")
    public DogResponse createDog(@Valid

                                 @RequestBody DogRequest request) {

        // Перетворюємо DTO у Entity.
        Dog dog = dogMapper.toEntity(request);

        // Зберігаємо Entity.
        Dog savedDog = dogService.saveDog(dog);

        // Перетворюємо Entity у DTO.
        return dogMapper.toResponse(savedDog);

    }

    @GetMapping("/dogs")
    public List<DogResponse> getAllDogs() {

        return dogMapper.toResponseList(

                dogService.getAllDogs()

        );

    }

    // Обробляємо GET-запит.
//
// GET /dogs/1
    @GetMapping("/dogs/{id}")
    public Optional<Dog> getDogById(

            // Беремо id із URL.
            @PathVariable Long id) {

        // Передаємо id у Service.
        return dogService.getDogById(id);

    }

    // Обробляємо PUT-запит.
//
// PUT /dogs/1
    @PutMapping("/dogs/{id}")
    public DogResponse updateDog(

            // Беремо id із URL.
            @PathVariable Long id,

            // Беремо JSON із тіла запиту.
            @RequestBody DogRequest request) {

        // Передаємо дані у Service.
        Dog updatedDog = dogService.updateDog(id, request);

        // Перетворюємо Entity у DTO.
        return dogMapper.toResponse(updatedDog);

    }

    // Обробляємо DELETE-запит.
//
// DELETE /dogs/1
    @DeleteMapping("/dogs/{id}")
    public void deleteDog(

            // Беремо id із URL.
            @PathVariable Long id) {

        // Передаємо id у Service.
        dogService.deleteDog(id);

    }

    @GetMapping("/dogs/name/{name}")
    public List<DogResponse> getDogsByName(

            @PathVariable String name) {

        return dogMapper.toResponseList(

                dogService.findByName(name)

        );

    }

    // GET /dogs/older-than/5
    @GetMapping("/dogs/older-than/{age}")
    public List<DogResponse> getOlderDogs(

            @PathVariable int age) {

        return dogMapper.toResponseList(

                dogService.findOlderThan(age)

        );

    }

}