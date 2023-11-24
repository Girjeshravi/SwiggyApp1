package com.example.FoodDeliveryApp2.utils;

import com.example.FoodDeliveryApp2.model.Restaurant;
import com.example.FoodDeliveryApp2.repository.RestaurantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidationUtils {

    final RestaurantRespository restaurantRespository;

    @Autowired
    public ValidationUtils(RestaurantRespository restaurantRespository) {
        this.restaurantRespository = restaurantRespository;
    }

    public boolean validateRestaurantId(int id){

        Optional<Restaurant> restaurantOptional = restaurantRespository.findById(id);
        // if(restaurantOptional.isEmpty()) return fallse;
        // return true;
        return restaurantOptional.isPresent();
    }
}
