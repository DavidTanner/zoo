package com.davidjoeltanner.zoo.dao;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryEntryDAO {
    
    @Autowired private final InventoryItemDAO item;
    @Autowired private final double newStock;
    @Autowired private final double oldStock;
    @Autowired private final LocalDateTime date;
    @Autowired private final double waste;
    
    public InventoryEntryDAO(InventoryItemDAO item, double oldStock, double newStock, LocalDateTime date) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (oldStock < 0) {
            throw new IllegalArgumentException("Old stock cannot be less than 0");
        }
        if (newStock < 0) {
            throw new IllegalArgumentException("New Stock cannot be less than 0");
        }
        
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.item = item;
        this.oldStock = oldStock;
        this.newStock = newStock;
        this.date = date;
        this.waste = newStock - oldStock;
    }

    public InventoryItemDAO getItem() {
        return item;
    }

    public double getNewStock() {
        return newStock;
    }

    public double getOldStock() {
        return oldStock;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
