package com.davidjoeltanner.zoo.objects;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column private String name;
    @Column private String species;
    
    @ManyToOne
    @JoinColumn(name = "animal", referencedColumnName="id")
    private Zoo zoo;
    

    @OneToMany(mappedBy = "animal") 
    private List<Feeding> feedings;

    
    protected Animal() {}

    public Animal(String name, String species, Zoo zoo) {
        this.name = name;
        this.species = species;
        this.zoo = zoo;
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
}
