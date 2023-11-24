package com.example.FoodDeliveryApp2.repository;

import com.example.FoodDeliveryApp2.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<FoodItem,Integer> {
}
