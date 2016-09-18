package com.davidjoeltanner.zoo.objects;

import java.util.List;

import javax.persistence.Column;
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
    

    @OneToMany(mappedBy = "animal", fetch = FetchType.EAGER) 
    private List<Feeding> feedings;
    
    public String getName() {
        return name;
    }
    
    public List<Feeding> getFeedings() {
        return feedings;
    }

    public void setFeedings(List<Feeding> feedings) {
        this.feedings = feedings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public Zoo getZoo() {
        return zoo;
    }
    
    public String getSpecies() {
        return species;
    }
}
