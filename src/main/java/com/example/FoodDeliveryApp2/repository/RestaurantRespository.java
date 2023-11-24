package com.example.FoodDeliveryApp2.repository;

import com.example.FoodDeliveryApp2.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRespository extends JpaRepository<Restaurant,Integer> {
}
