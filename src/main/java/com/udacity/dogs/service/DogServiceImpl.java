package com.udacity.dogs.service;

import com.udacity.dogs.model.Dog;
import com.udacity.dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Override
    public List<Dog> retrieveDogs() {
        return null;
    }

    @Override
    public List<String> retrieveDogBreed() {
        return null;
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        return null;
    }

    @Override
    public List<String> retrieveDogNames() {
        return null;
    }
}
