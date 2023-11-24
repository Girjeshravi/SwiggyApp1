package com.example.FoodDeliveryApp2.transformer;

import com.example.FoodDeliveryApp2.dto.request.MenuRequest;
import com.example.FoodDeliveryApp2.dto.response.MenuResponse;
import com.example.FoodDeliveryApp2.model.MenuItem;

public class MenuItemTransformer {

    public static MenuItem MenuRequestToMenuItem(MenuRequest menuRequest){
        return MenuItem.builder()
                .dishName(menuRequest.getDishName())
                .price(menuRequest.getPrice())
                .category(menuRequest.getCategory())
                .veg(menuRequest.isVeg())
                .available(menuRequest.isAvailable())
                .build();
    }

    public static MenuResponse MenuItemToMenuResponse(MenuItem menuItem){
        return MenuResponse.builder()
                .dishName(menuItem.getDishName())
                .price(menuItem.getPrice())
                .veg(menuItem.isVeg())
                .category(menuItem.getCategory())
                .build();
    }
}
