package com.udacity.dogs.controller;

import com.udacity.dogs.model.Dog;
import com.udacity.dogs.service.DogNotFoundException;
import com.udacity.dogs.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> dogs = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> getDogBreeds(){
        List<String> breeds = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }

    @GetMapping("/breed/{id}")
    public ResponseEntity<String> getBreedById(@PathVariable Long id){
        try {
            String dogBreed = dogService.retrieveDogBreedById(id);
            return new ResponseEntity<String>(dogBreed, HttpStatus.OK);
        } catch (DogNotFoundException e){
            //dnfe.getMessage();
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getDogNames(){
        List<String> names = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }
}
