package com.example.dog_api.service;

import com.example.dog_api.dto.DogRequest;
import com.example.dog_api.model.Dog;
import com.example.dog_api.repository.DogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    // Repository.
    private final DogRepository repository;

    // Конструктор.
    public DogService(DogRepository repository) {

        this.repository = repository;

    }

    public Dog getDog() {

        Dog dog = new Dog();

        dog.setName("Bobik");

        dog.setAge(5);

        return dog;

    }

    public Dog saveDog(Dog dog) {

        // Передаємо собаку Repository.
        return repository.save(dog);

    }

    public List<Dog> getAllDogs() {
        return repository.findAll();
    }

    public Optional<Dog> getDogById(Long id) {
        return repository.findById(id);
    }

    public Dog updateDog(Long id, DogRequest request) {
        // Шукаємо собаку за id.
        Dog dog = repository.findById(id).orElseThrow();

        // Змінюємо ім'я.
        dog.setName(request.getName());

        // Змінюємо вік.
        dog.setAge(request.getAge());

        // Зберігаємо зміни.
        return repository.save(dog);
    }

    public void deleteDog(Long id) {
        // Видаляємо запис за id.
        repository.deleteById(id);

    }

    // Повертаємо собак за ім'ям.
    public List<Dog> findByName(String name) {

        return repository.findByName(name);

    }

    // Повертаємо собак,
// старших за заданий вік.
    public List<Dog> findOlderThan(int age) {

        return repository.findByAgeGreaterThan(age);

    }

}