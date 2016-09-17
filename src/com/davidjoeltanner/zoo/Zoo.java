package com.davidjoeltanner.zoo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Zoo {
    
    private final static List<Zoo> _zoos = new ArrayList<>();

    private final List<Animal> animals;
    private String name;
    private final Set<InventoryItem> inventory;
    private final List<InventoryEntry> inventorySession;
    
    
    public List<Animal> getAnimals() {
        return animals;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addInventory(InventoryItem item) {
        inventory.add(item);
    }
    
    public Set<InventoryItem> getInventory() {
        return inventory;
    }
    
    public List<InventoryEntry> getInventorySession() {
        return inventorySession;
    }
    
    public List<Zoo> getAllZoos() {
        return _zoos;
    }
    
    public Zoo(String name) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null");
        }
        this.inventory = new HashSet<>();
        this.animals = new ArrayList<>();
        this.inventorySession = new ArrayList<>();
    }
}
