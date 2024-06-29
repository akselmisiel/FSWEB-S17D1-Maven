package com.workintech.fswebs17d1.controller;


import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void init() {
        animals = new HashMap<>();
        animals.put(1, new Animal(1, "Maymun"));
    }

    @GetMapping
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable("id") int id) {
        return animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable("id") int id, @RequestBody Animal animal) {
        animals.replace(id, animal);
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable("id") int id) {
        animals.remove(id);
    }

}
