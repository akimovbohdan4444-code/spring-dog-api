package com.example.dog_api.mapper;

// DTO.
import com.example.dog_api.dto.DogRequest;
import com.example.dog_api.dto.DogResponse;

// Entity.
import com.example.dog_api.model.Dog;

// Позначаємо клас як Spring Bean.
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DogMapper {

    // Перетворює DogRequest у Dog(Entity).
    public Dog toEntity(DogRequest request) {

        // Створюємо Entity.
        Dog dog = new Dog();

        // Копіюємо ім'я.
        dog.setName(request.getName());

        // Копіюємо вік.
        dog.setAge(request.getAge());

        // Повертаємо Entity.
        return dog;

    }

    // Перетворює Dog(Entity) у DogResponse.
    public DogResponse toResponse(Dog dog) {

        // Створюємо Response.
        DogResponse response = new DogResponse();

        // Копіюємо id.
        response.setId(dog.getId());

        // Копіюємо ім'я.
        response.setName(dog.getName());

        // Копіюємо вік.
        response.setAge(dog.getAge());

        // Повертаємо Response.
        return response;

    }

    // Перетворює список Entity у список Response.
    public List<DogResponse> toResponseList(List<Dog> dogs) {

        // Створюємо новий список.
        List<DogResponse> response = new ArrayList<>();

        // Проходимося по всіх собаках.
        for (Dog dog : dogs) {

            // Додаємо Response у список.
            response.add(toResponse(dog));

        }

        // Повертаємо список.
        return response;

    }

}