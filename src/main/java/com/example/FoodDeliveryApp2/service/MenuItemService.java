package com.example.FoodDeliveryApp2.service;

import com.example.FoodDeliveryApp2.Enum.FoodCategory;
import com.example.FoodDeliveryApp2.dto.request.MenuRequest;
import com.example.FoodDeliveryApp2.dto.response.MenuResponse;
import com.example.FoodDeliveryApp2.exception.MenuItemNotFoundException;
import com.example.FoodDeliveryApp2.model.MenuItem;
import com.example.FoodDeliveryApp2.repository.MenuItemRepository;
import com.example.FoodDeliveryApp2.transformer.MenuItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {
    @Autowired
    MenuItemRepository menuItemRepository;
    public MenuResponse addMenuItems(MenuRequest menuRequest) {
        MenuItem menuItem= MenuItemTransformer.MenuRequestToMenuItem(menuRequest);
        MenuItem savedMenuItem=menuItemRepository.save(menuItem);
        return  MenuItemTransformer.MenuItemToMenuResponse(savedMenuItem);
    }

    public MenuResponse findMenuItemsByCategory(FoodCategory category) {
        MenuItem menuItem=menuItemRepository.findMenuItemsByCategory(category);
        if(menuItem==null){
            throw new MenuItemNotFoundException("Invalid category !!");
        }
        return MenuItemTransformer.MenuItemToMenuResponse(menuItem);
    }
    public MenuResponse findMenuItemsByCategoryandPrice(FoodCategory category,double price) {
        MenuItem menuItem=menuItemRepository.findMenuItemsByCategoryandPrice(category,price);
        if(menuItem==null){
            throw new MenuItemNotFoundException("Invalid category or price ");
        }
        return MenuItemTransformer.MenuItemToMenuResponse(menuItem);
    }

    public MenuResponse findMenuItemsByVeg(boolean veg) {
        MenuItem menuItem=menuItemRepository.findMenuItemsByVeg(veg);
        if(menuItem==null){
            throw new MenuItemNotFoundException("Invalid category or price ");
        }
        return MenuItemTransformer.MenuItemToMenuResponse(menuItem);
    }
}
