package com.davidjoeltanner.zoo;

import java.util.Scanner;


import com.davidjoeltanner.zoo.models.AnimalDAO;
import com.davidjoeltanner.zoo.models.FeedingDAO;
import com.davidjoeltanner.zoo.models.InventoryEntryDAO;
import com.davidjoeltanner.zoo.models.InventoryItemDAO;
import com.davidjoeltanner.zoo.models.ZooDAO;
import com.davidjoeltanner.zoo.objects.Animal;
import com.davidjoeltanner.zoo.objects.InventoryItem;
import com.davidjoeltanner.zoo.objects.Zoo;

public class Objects {

    private final AnimalDAO animalDao;
    private final ZooDAO zooDao;
    private final FeedingDAO feedingDao;
    private final InventoryEntryDAO invEntryDao;
    private final InventoryItemDAO invItemDao;
    
    private final Scanner scanner;
    
    public Objects(AnimalDAO animalDao, ZooDAO zooDao, FeedingDAO feedingDao, InventoryItemDAO inventoryitemDao, InventoryEntryDAO inventoryEntryDao) {
        this.scanner = new Scanner(System.in);
        this.animalDao = animalDao;
        this.zooDao = zooDao;
        this.invEntryDao = inventoryEntryDao;
        this.invItemDao = inventoryitemDao;
        this.feedingDao = feedingDao;
    }
    
    private String getString() {
        String entry = scanner.nextLine().trim();
        while(entry == null || entry.isEmpty()) {
            entry = scanner.nextLine().trim();
        }
        return entry;
    }

    
    public Zoo getZoo() {
        System.out.print("Please enter the zoo name: ");
        String name = getString();
        return getZoo(name);
    }
    
    private Zoo getZoo(String name) {
        Zoo zoo = zooDao.findByName(name);
        if (zoo != null) {
            return zoo;
        }
        zoo = new Zoo();
        zoo.setName(name);
        zooDao.save(zoo);
        return zoo;
    }

    public Animal getAnimal(String name, String species) {
        Zoo zoo = getZoo();
        return getAnimal(name, species, zoo);
    }
    
    private Animal getAnimal(String name, String species, Zoo zoo) {
        Animal animal = animalDao.findByNameAndSpeciesAndZoo(name, species, zoo);
        if (animal != null) {
            return animal;
        }
        animal = new Animal();
        animal.setZoo(zoo);
        animal.setName(name);
        animal.setSpecies(species);
        animalDao.save(animal);
        return animal;
    }
    
    public Animal getAnimal(Zoo zoo) {
        System.out.print("Please enter the animals Name: ");
        String name = getString();
        System.out.print("Please enter the animals Species: ");
        String species = getString();
        return getAnimal(name, species, zoo);
    }
    
    public Animal createAnimal() {
        System.out.print("Please enter the animals Name: ");
        String name = getString();
        System.out.print("Please enter the animals Species: ");
        String species = getString();
        System.out.print("Please enter the Zoo to which " + name + " belongs: ");
        String zooName = getString();
        Zoo zoo = getZoo(zooName);
        return getAnimal(name, species, zoo);
    }

    public InventoryItem getInventoryItem() {
        Zoo zoo = getZoo();
        return getInventoryItem(zoo);
    }
    
    
    public InventoryItem getInventoryItem(Zoo zoo) {
        System.out.println("Please enter the item name: ");
        String name = getString();
        
        InventoryItem item = invItemDao.findByNameAndZoo(name, zoo);
        if (item != null) {
            return item;
        }
        
        item = new InventoryItem();
        item.setName(name);
        System.out.println("Please enter how many/much you have of " + name + ": ");
        double stock = scanner.nextDouble();
        item.setStock(stock);
        item.setZoo(zoo);
        invItemDao.save(item);
        return item;
    }
    
}
