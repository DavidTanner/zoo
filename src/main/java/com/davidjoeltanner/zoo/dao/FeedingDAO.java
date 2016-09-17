package com.davidjoeltanner.zoo.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedingDAO {
    
    @Autowired private LocalDateTime date;
    @Autowired private double amount;
    @Autowired private InventoryItemDAO item;
    @Autowired private AnimalDAO animal;
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public InventoryItemDAO getItem() {
        return item;
    }

    public void setItem(InventoryItemDAO item) {
        this.item = item;
    }

    public AnimalDAO getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDAO animal) {
        this.animal = animal;
    }
    
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public FeedingDAO(LocalDateTime date, InventoryItemDAO item, double amount, AnimalDAO animal) {
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
