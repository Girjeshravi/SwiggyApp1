package com.example.FoodDeliveryApp2.repository;

import com.example.FoodDeliveryApp2.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepo extends JpaRepository<OrderEntity,Integer> {
}
