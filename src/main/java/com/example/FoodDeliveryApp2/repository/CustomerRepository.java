package com.example.FoodDeliveryApp2.repository;

import com.example.FoodDeliveryApp2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer findByMobileNo(String mobile);
}
