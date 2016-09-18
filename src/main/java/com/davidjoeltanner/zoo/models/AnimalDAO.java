package com.davidjoeltanner.zoo.models;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidjoeltanner.zoo.objects.Animal;
import com.davidjoeltanner.zoo.objects.Zoo;

@Transactional
public interface AnimalDAO extends JpaRepository<Animal, Long> {
    public Animal findByName(String name);
    public Animal findByNameAndSpeciesAndZoo(String name, String species, Zoo zoo);
}
