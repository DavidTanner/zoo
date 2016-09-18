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
        log.info("creating tables");
        Zoo zoo = new Zoo();
        zoo.setName("Cincinatti");
        
        zooDao.save(zoo);
        
        log.info("Should be 1 " + zooDao.count());
        zoo = zooDao.findByName("Cincinatti");
        log.info(zoo.getName());
    }

}
