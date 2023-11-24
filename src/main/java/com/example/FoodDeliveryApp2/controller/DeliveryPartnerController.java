package com.example.FoodDeliveryApp2.controller;

import com.example.FoodDeliveryApp2.dto.request.DeliveryPartnerRequest;
import com.example.FoodDeliveryApp2.service.DeliveryPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/partner")
public class DeliveryPartnerController {

    final DeliveryPartnerService deliveryPartnerService;

    @Autowired
    public DeliveryPartnerController(DeliveryPartnerService deliveryPartnerService) {
        this.deliveryPartnerService = deliveryPartnerService;
    }

    @PostMapping("/add")
    public ResponseEntity addDeliveryPartner(@RequestBody DeliveryPartnerRequest deliveryPartnerRequest){

        String message = deliveryPartnerService.addPartner(deliveryPartnerRequest);
        return new ResponseEntity(message, HttpStatus.CREATED);
    }

    // give delivery partner with highest number of deliveries

    // send an email to all the partners who have done less than 10 deliveries.


}
