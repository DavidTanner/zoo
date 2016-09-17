package com.davidjoeltanner.zoo.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryItemDAO {

    @Autowired private String name;
    @Autowired private double stock;
    
    private final List<InventoryEntryDAO> inventoryEntries;
    
    public InventoryItemDAO(String name, double stock) {
        this.setName(name);
        this.setStock(stock);
        inventoryEntries = new ArrayList<>();
        inventoryEntries.add(new InventoryEntryDAO(this, 0, stock, LocalDateTime.now()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        setStock(stock, LocalDateTime.now());
    }
    
    public void setStock(double stock, LocalDateTime date) {
        this.inventoryEntries.add(new InventoryEntryDAO(this, this.stock, stock, date));
        this.stock = stock;
    }
}
