package com.davidjoeltanner.zoo.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidjoeltanner.zoo.objects.InventoryEntry;

public interface InventoryEntryDAO extends JpaRepository<InventoryEntry, Long>{

}
