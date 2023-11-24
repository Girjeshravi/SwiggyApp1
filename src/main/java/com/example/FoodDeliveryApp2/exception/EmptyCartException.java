package com.example.FoodDeliveryApp2.exception;

public class EmptyCartException extends RuntimeException{

    public EmptyCartException(String message){
        super(message);
    }
}
