package com.davidjoeltanner.zoo.objects;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventoryEntry")
public class InventoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "item", referencedColumnName="id")
    private InventoryItem item;
    
    private double newStock;
    private double oldStock;
    private LocalDateTime date;
    private double waste;
    
    public InventoryItem getItem() {
        return item;
    }
    public void setItem(InventoryItem item) {
        this.item = item;
    }
    public double getNewStock() {
        return newStock;
    }
    public void setNewStock(double newStock) {
        this.newStock = newStock;
    }
    public double getOldStock() {
        return oldStock;
    }
    public void setOldStock(double oldStock) {
        this.oldStock = oldStock;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public double getWaste() {
        return waste;
    }
    public void setWaste(double waste) {
        this.waste = waste;
    }
    
}
