package com.example.FoodDeliveryApp2.exception;

public class RestaurantNotFoundException extends RuntimeException{

    public RestaurantNotFoundException(String message){
        super(message);
    }
}
