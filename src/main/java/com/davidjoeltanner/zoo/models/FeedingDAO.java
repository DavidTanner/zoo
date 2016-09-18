package com.davidjoeltanner.zoo.models;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davidjoeltanner.zoo.objects.Feeding;

@Transactional
public interface FeedingDAO extends JpaRepository<Feeding, Long> {

}
