package com.davidjoeltanner.zoo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import com.davidjoeltanner.zoo.models.AnimalDAO;
import com.davidjoeltanner.zoo.models.FeedingDAO;
import com.davidjoeltanner.zoo.models.InventoryEntryDAO;
import com.davidjoeltanner.zoo.models.InventoryItemDAO;
import com.davidjoeltanner.zoo.models.ZooDAO;
import com.davidjoeltanner.zoo.objects.Animal;

public class Reports {
    private final AnimalDAO animalDao;
    private final ZooDAO zooDao;
    private final FeedingDAO feedingDao;
    private final InventoryEntryDAO invEntryDao;
    private final InventoryItemDAO invItemDao;
    
    private final Scanner scanner;
    
    public Reports(AnimalDAO animalDao, ZooDAO zooDao, FeedingDAO feedingDao, InventoryItemDAO inventoryitemDao, InventoryEntryDAO inventoryEntryDao) {
        this.scanner = new Scanner(System.in);
        this.animalDao = animalDao;
        this.zooDao = zooDao;
        this.invEntryDao = inventoryEntryDao;
        this.invItemDao = inventoryitemDao;
        this.feedingDao = feedingDao;
    }
    
    public void run() {
        int option = menu();
        while(option != 0) {
            switch (option) {
                case 1: 
                    animalDao.findAll().forEach(animal -> 
                    System.out.printf("%s is a %s in the %s zoo\n", 
                                      animal.getName(), animal.getSpecies(), animal.getZoo().getName())
                    );
                    break;
                case 2: 
                    runAverageFeedingReport();
                    break;
            }
            option = menu();
        }
    }
    
    private void runAverageFeedingReport() {
        final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final Map<Animal, Map<String, Double>> counters = new HashMap<>();
        
        feedingDao.findAll().forEach(feeding -> {
            Animal animal = feeding.getAnimal();
            LocalDateTime dateTime = feeding.getDateTime();
            double amount = feeding.getAmount();
            String bucket = dateTime.format(format);
            counters.compute(animal, (k1, v1) -> {
                if (v1 == null) {
                    v1 = new HashMap<>();
                }
                v1.compute(bucket, (k2, v2) -> {
                    return (v2 == null ? 0 : v2) + amount;
                });
                return v1;
            });
        });
        
        counters.forEach((animal, buckets) -> {
            final List<Double> byDay = new ArrayList<>();
            buckets.forEach((bucket, amount) -> {
                byDay.add(amount);
            });
            double average = byDay.stream().mapToDouble(a -> a).average().getAsDouble();
            System.out.printf("%s, a %s in the %s zoo, was fed, on average, %3.1f units each day.\n", 
                              animal.getName(), animal.getSpecies(), animal.getZoo().getName(), average);
        });
    }
        
    
    private int menu() {
        System.out.println("\nPlease choose from the following options: ");
        System.out.println("0: Return to main menu");
        System.out.println("1: List Animals in all Zoos");
        System.out.println("2: Average feeding amount by animal");
        int option = scanner.nextInt();
        return option;
    }
    

}
