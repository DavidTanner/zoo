package com.davidjoeltanner.zoo.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnimalDAO {

    @Autowired private final String name;
    @Autowired private String species;
    @Autowired private ZooDAO zoo;
    private final List<FeedingDAO> feedings;
    
    public AnimalDAO(ZooDAO zoo, String name, String species) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        if (zoo == null) {
            throw new NullPointerException("Zoo cannot be null");
        }
        if (species == null) {
            throw new NullPointerException("Species cannot be null");
        }
        this.zoo = zoo;
        this.name = name;
        this.species = species;
        feedings = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public ZooDAO getZoo() {
        return zoo;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public List<FeedingDAO> getFeedings() {
        return feedings;
    }
    
    public void feedAnimal(InventoryItemDAO item, double amount) {
        feedAnimal(LocalDateTime.now(), item, amount);
    }
    
    public void feedAnimal(LocalDateTime date, InventoryItemDAO item, double amount) {
        FeedingDAO feeding = new FeedingDAO(date, item, amount, this);
        feedings.add(feeding);
    }
}
