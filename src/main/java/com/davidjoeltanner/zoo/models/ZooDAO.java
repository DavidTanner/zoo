package com.davidjoeltanner.zoo.models;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidjoeltanner.zoo.objects.Zoo;

public interface ZooDAO extends JpaRepository<Zoo, Long>{
    public Zoo findByName(String name);
}
