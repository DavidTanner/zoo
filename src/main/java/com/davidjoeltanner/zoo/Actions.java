package com.davidjoeltanner.zoo;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.davidjoeltanner.zoo.models.AnimalDAO;
import com.davidjoeltanner.zoo.models.FeedingDAO;
import com.davidjoeltanner.zoo.models.InventoryEntryDAO;
import com.davidjoeltanner.zoo.models.InventoryItemDAO;
import com.davidjoeltanner.zoo.models.ZooDAO;
import com.davidjoeltanner.zoo.objects.Animal;
import com.davidjoeltanner.zoo.objects.Feeding;
import com.davidjoeltanner.zoo.objects.InventoryItem;
import com.davidjoeltanner.zoo.objects.Zoo;

public class Actions {
    private final AnimalDAO animalDao;
    private final ZooDAO zooDao;
    private final FeedingDAO feedingDao;
    private final InventoryEntryDAO invEntryDao;
    private final InventoryItemDAO invItemDao;
    
    private final Objects objects;
    
    private final Scanner scanner;
    
    public Actions(AnimalDAO animalDao, ZooDAO zooDao, FeedingDAO feedingDao, InventoryItemDAO inventoryitemDao, InventoryEntryDAO inventoryEntryDao) {
        this.scanner = new Scanner(System.in);
        this.animalDao = animalDao;
        this.zooDao = zooDao;
        this.invEntryDao = inventoryEntryDao;
        this.invItemDao = inventoryitemDao;
        this.feedingDao = feedingDao;
        this.objects = new Objects(animalDao, zooDao, feedingDao, inventoryitemDao, inventoryEntryDao);
    }
    
    
    public void feedAnimal() {
        Zoo zoo = objects.getZoo();
        Animal animal = objects.getAnimal(zoo);
        InventoryItem item = objects.getInventoryItem();
        
        System.out.println("How much/many are you feeding " + animal.getName() + "?");
        double amount = scanner.nextDouble();
        
        Feeding feeding = new Feeding();
        feeding.setAnimal(animal);
        feeding.setItem(item);
        feeding.setAmount(amount);
        feeding.setDateTime(LocalDateTime.now());
        feedingDao.save(feeding);
    }

}
