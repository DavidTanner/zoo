package com.davidjoeltanner.zoo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Feeding {
    
    private static final List<Feeding> _feedings = new ArrayList<>();

    private LocalDateTime date;
    private double amount;
    private InventoryItem item;
    private Animal animal;
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public InventoryItem getItem() {
        return item;
    }

    public void setItem(InventoryItem item) {
        this.item = item;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public List<Feeding> getAllFeedings() {
        return _feedings;
    }

    public Feeding(LocalDateTime date, double amount, InventoryItem item, Animal animal) {
        if (date == null) {
            throw new NullPointerException("Date cannot be null");
        }
        if (amount == 0) {
            throw new IllegalArgumentException("amount cannot be 0");
        }
        if (item == null) {
            throw new NullPointerException("Item cannot be null");
        }
        if (animal == null) {
            throw new NullPointerException("Animal cannot be null");
        }
        this.date = date;
        this.amount = amount;
        this.item = item;
        this.animal = animal;
    }
    
}
