package com.davidjoeltanner.zoo.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZooDAO {
    
    private final List<AnimalDAO> animals;
    @Autowired private String name;
    @Autowired private final Set<InventoryItemDAO> inventory;
    
    public List<AnimalDAO> getAnimals() {
        return animals;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addInventory(InventoryItemDAO item) {
        inventory.add(item);
    }
    
    public Set<InventoryItemDAO> getInventory() {
        return inventory;
    }
    
    public ZooDAO(String name) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        this.inventory = new HashSet<>();
        this.animals = new ArrayList<>();
    }
}
