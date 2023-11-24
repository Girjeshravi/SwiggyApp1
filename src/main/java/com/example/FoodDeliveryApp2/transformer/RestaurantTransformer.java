package com.example.FoodDeliveryApp2.transformer;

import com.example.FoodDeliveryApp2.dto.request.RestaurantRequest;
import com.example.FoodDeliveryApp2.dto.response.MenuResponse;
import com.example.FoodDeliveryApp2.dto.response.RestaurantResponse;
import com.example.FoodDeliveryApp2.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantTransformer {

    public static Restaurant RestaurantRequestToRestaurant(RestaurantRequest restaurantRequest){
        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .contactNumber(restaurantRequest.getContactNumber())
                .location(restaurantRequest.getLocation())
                .restrauntCategory(restaurantRequest.getRestrauntCategory())
                .opened(true)//we will not use (.isOpend) because (.isX) represent getX or setX
                .availableMenuItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
    }

    public static RestaurantResponse RestaurantToRestaurantResponse(Restaurant restaurant){
        //restaurant is just a variable name given above in function
        List<MenuResponse> menu = restaurant.getAvailableMenuItems()
                .stream()
                .map(foodItem -> MenuItemTransformer.MenuItemToMenuResponse(foodItem))
                .collect(Collectors.toList());
        // here fooditem can be any variable

        return RestaurantResponse.builder()
                .name(restaurant.getName())
                .contactNumber(restaurant.getContactNumber())
                .location(restaurant.getLocation())
                .opened(restaurant.isOpened())
                .menu(menu)
                .build();
    }
}
