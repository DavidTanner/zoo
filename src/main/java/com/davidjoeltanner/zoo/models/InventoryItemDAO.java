package com.davidjoeltanner.zoo.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidjoeltanner.zoo.objects.InventoryItem;

public interface InventoryItemDAO extends JpaRepository<InventoryItem, Long>{
    public InventoryItem findByName(String name);
}
