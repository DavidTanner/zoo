package com.davidjoeltanner.zoo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.format.datetime.standard.TemporalAccessorParser;

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

    private String getString() {
        String entry = scanner.nextLine().trim();
        while(entry == null || entry.isEmpty()) {
            entry = scanner.nextLine().trim();
        }
        return entry;
    }
    
    public void feedAnimal() {
        Zoo zoo = objects.getZoo();
        Animal animal = objects.getAnimal(zoo);
        InventoryItem item = objects.getInventoryItem(zoo);
        
        System.out.println("How much/many " + item.getName() + " are you feeding " + animal.getName() + "?");
        double amount = scanner.nextDouble();
        
        System.out.println("When did you feed " + animal.getName() + ", enter now or the date in YYYY-MM-DD hh:mm:ss format please.");
        String dateTime = getString();
        LocalDateTime date = LocalDateTime.now();
        if (dateTime != null && !dateTime.isEmpty() && !dateTime.equalsIgnoreCase("now")) {
            try {
                date = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            } catch (Exception e) {
                System.out.printf("We were unable to understand (%s), returning to menu. %s", dateTime, e.getMessage());
                return;
            }
        }
        
        Feeding feeding = new Feeding();
        feeding.setAnimal(animal);
        feeding.setItem(item);
        feeding.setAmount(amount);
        feeding.setDateTime(date);
        feedingDao.save(feeding);
    }

}
