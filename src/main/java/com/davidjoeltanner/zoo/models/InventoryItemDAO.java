package com.davidjoeltanner.zoo.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidjoeltanner.zoo.objects.InventoryItem;
import com.davidjoeltanner.zoo.objects.Zoo;

public interface InventoryItemDAO extends JpaRepository<InventoryItem, Long>{
    public List<InventoryItem> findByName(String name);
    public InventoryItem findByNameAndZoo(String name, Zoo zoo);
}
