package com.example.FoodDeliveryApp2.repository;

import com.example.FoodDeliveryApp2.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
}
