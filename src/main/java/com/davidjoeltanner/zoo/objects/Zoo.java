package com.davidjoeltanner.zoo.objects;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="zoos")
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; 
    private String name;
    
    @OneToMany(mappedBy = "zoo")
    private List<Animal> animals;
    
    @OneToMany(mappedBy = "zoo") 
    private List<InventoryItem> inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    
}
