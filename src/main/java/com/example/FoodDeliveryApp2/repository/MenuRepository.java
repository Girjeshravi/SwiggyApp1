package com.example.FoodDeliveryApp2.repository;

import com.example.FoodDeliveryApp2.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem,Integer> {
}
