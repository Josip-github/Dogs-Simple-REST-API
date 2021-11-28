package com.udacity.dogs.service;

import com.udacity.dogs.model.Dog;
import com.udacity.dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        List<String> breed = new ArrayList<>();
        for (Dog dog: dogs) {
            breed.add(dog.getBreed());
        }
        return breed;
    }

    @Override
    public String retrieveDogBreedById(Long id) throws DogNotFoundException {
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        List<Long> listOfIds = new ArrayList<>();
        for (Dog dog: dogs) {
            listOfIds.add(dog.getId());
        }

        if(!listOfIds.contains(id)){
            throw new DogNotFoundException("Dog not found");
        }

        Dog dogFoundById = new Dog();
        for (Dog dog: dogs) {
            if (dog.getId() == id){
                dogFoundById = dog;
                break;
            }
        }
        return dogFoundById.getBreed();
    }

    @Override
    public List<String> retrieveDogNames() {
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        List<String> names = new ArrayList<>();
        for (Dog dog: dogs) {
            names.add(dog.getName());
        }
        return names;
    }
}
