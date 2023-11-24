package com.example.FoodDeliveryApp2.exception;

public class MenuItemNotFoundException extends RuntimeException{
    public MenuItemNotFoundException(String message){
        super(message);
    }
}
