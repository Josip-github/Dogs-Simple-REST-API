package com.udacity.dogs.repository;

import com.udacity.dogs.model.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {

    /*
    This snippet of code is copied and pasted from Udacity's lesson;
    it's not necessarily needed. But it's good to know.

    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(Long id);

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();
    */
}
