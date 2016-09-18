package com.davidjoeltanner.zoo.models;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidjoeltanner.zoo.objects.Animal;

@Transactional
public interface AnimalDAO extends JpaRepository<Animal, Long> {

}
