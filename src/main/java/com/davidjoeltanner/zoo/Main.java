package com.davidjoeltanner.zoo;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.davidjoeltanner.zoo.models.AnimalDAO;
import com.davidjoeltanner.zoo.models.FeedingDAO;
import com.davidjoeltanner.zoo.models.InventoryEntryDAO;
import com.davidjoeltanner.zoo.models.InventoryItemDAO;
import com.davidjoeltanner.zoo.models.ZooDAO;
import com.davidjoeltanner.zoo.objects.Zoo;

@SpringBootApplication
public class Main implements CommandLineRunner{

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired JdbcTemplate jdbcTemplate;
    @Autowired AnimalDAO animalDao;
    @Autowired ZooDAO zooDao;
    @Autowired FeedingDAO feedingDao;
    @Autowired InventoryEntryDAO invEntryDao;
    @Autowired InventoryItemDAO invItemDao;
    

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Objects create = new Objects(animalDao, zooDao, feedingDao, invItemDao, invEntryDao);
        Actions actions = new Actions(animalDao, zooDao, feedingDao, invItemDao, invEntryDao);
        Reports reports = new Reports(animalDao, zooDao, feedingDao, invItemDao, invEntryDao);
        
        int option = menu(scanner);
        while (option != 0) {
            switch (option) {
                case 1: 
                    create.getZoo();
                    break;
                case 2:
                    create.createAnimal();
                    break;
                case 4: 
                    actions.feedAnimal();
                    break;
                    
                case 6:
                    reports.run();
                    break;
            
            }
            option = menu(scanner);
        }
    }
    
    
    private int menu(Scanner scanner) {
        System.out.println("\n");
        System.out.println("Please select an option:");
        System.out.println("0: Exit program, History is lost due to time bug");
        System.out.println("1: Add a Zoo");
        System.out.println("2: Add an Animal");
        System.out.println("3: Add an Inventory Item");
        System.out.println("4: Feed an Animal");
        System.out.println("5: Update Inventory");
        System.out.println("6: Run Report");
        
        int option = scanner.nextInt();
        System.out.println("\n");
        return option;
    }

}
