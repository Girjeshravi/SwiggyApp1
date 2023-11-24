package com.example.FoodDeliveryApp2.transformer;

import com.example.FoodDeliveryApp2.dto.request.DeliveryPartnerRequest;
import com.example.FoodDeliveryApp2.model.DeliveryPartner;

import java.util.ArrayList;

public class PartnerTransformer {

    public static DeliveryPartner PartnerRequestToDeliveryPartner(
            DeliveryPartnerRequest deliveryPartnerRequest){

        return DeliveryPartner.builder()
                .name(deliveryPartnerRequest.getName())
                .mobileNo(deliveryPartnerRequest.getMobileNo())
                .gender(deliveryPartnerRequest.getGender())
                .orders(new ArrayList<>())
                .build();
    }
}
