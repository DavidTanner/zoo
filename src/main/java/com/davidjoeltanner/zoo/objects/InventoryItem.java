package com.davidjoeltanner.zoo.objects;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="inventoryItem")
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double stock;

    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private List<InventoryEntry> inventoryEntries;
    
    @ManyToOne
    @JoinColumn(name = "zoo", referencedColumnName="id")
    private Zoo zoo;
    
    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public List<InventoryEntry> getInventoryEntries() {
        return inventoryEntries;
    }

    public void setInventoryEntries(List<InventoryEntry> inventoryEntries) {
        this.inventoryEntries = inventoryEntries;
    }

    public void setStock(double stock) {
        this.stock = stock;
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
}
