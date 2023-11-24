package com.example.FoodDeliveryApp2.service;

import com.example.FoodDeliveryApp2.dto.request.DeliveryPartnerRequest;
import com.example.FoodDeliveryApp2.model.DeliveryPartner;
import com.example.FoodDeliveryApp2.repository.DeliveryPartnerRepo;
import com.example.FoodDeliveryApp2.transformer.PartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPartnerService {

    final DeliveryPartnerRepo deliveryPartnerRepo;

    @Autowired
    public DeliveryPartnerService(DeliveryPartnerRepo deliveryPartnerRepo) {
        this.deliveryPartnerRepo = deliveryPartnerRepo;
    }

    public String addPartner(DeliveryPartnerRequest deliveryPartnerRequest) {

        //dto -> entity
        DeliveryPartner deliveryPartner = PartnerTransformer.PartnerRequestToDeliveryPartner(deliveryPartnerRequest);

        // save
        DeliveryPartner savedPartner = deliveryPartnerRepo.save(deliveryPartner);

        return "You have been successfully regsitered!!!";

    }
}
