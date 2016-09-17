package com.davidjoeltanner.zoo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    
    private final static List<Animal> _animals = new ArrayList<>();

    private final String name;
    private String species;
    private Zoo zoo;
    private final List<Feeding> feedings;
    
    public Animal(Zoo zoo, String name, String species) {
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
        _animals.add(this);
    }
    
    public String getName() {
        return name;
    }
    
    public Zoo getZoo() {
        return zoo;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public List<Feeding> getFeedings() {
        return feedings;
    }
    
    public void feedAnimal(InventoryItem food, double amount) {
        feedAnimal(LocalDateTime.now(), food, amount);
    }
    
    public void feedAnimal(LocalDateTime date, InventoryItem food, double amount) {
        Feeding feeding = new Feeding();
        feedings.add(feeding);
    }
}
