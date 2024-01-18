package com.example.FoodDeliveryApp2.controller;

import com.example.FoodDeliveryApp2.Enum.FoodCategory;
import com.example.FoodDeliveryApp2.dto.request.MenuRequest;
import com.example.FoodDeliveryApp2.dto.response.MenuResponse;
import com.example.FoodDeliveryApp2.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    // add menuitems
    @Autowired
    MenuItemService menuItemService;

    @PostMapping("/add")
    public ResponseEntity addMenuItems(@RequestBody MenuRequest menuRequest){
        MenuResponse menuResponse=menuItemService.addMenuItems(menuRequest);
        return new ResponseEntity(menuResponse, HttpStatus.CREATED);
    }

    // get all foods of a particualr category

    @GetMapping("/getcategory/category/{category}")
    public ResponseEntity getMenuItemByCategory(@PathVariable ("category")FoodCategory category){
        try{
            MenuResponse menuResponse=menuItemService.findMenuItemsByCategory(category);
            return new ResponseEntity(menuResponse,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CREATED);
        }
    }

    // get all MAIN_COURSE items with price above x rupees from a particular restaurant.
    @GetMapping("/getveg/veg/{veg}")
    public ResponseEntity getMenuItemByVeg(@PathVariable ("veg")boolean veg){
        try{
            MenuResponse menuResponse= menuItemService.findMenuItemsByVeg(veg);
            return new ResponseEntity(menuResponse,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CREATED);
        }
    }

    // get all veg foods of a restaurant
    @GetMapping("/getcategory/category/{category}/price/{price}")
    public ResponseEntity getMenuItemByPrice(@PathVariable ("category")FoodCategory category,@PathVariable("price")double price){
        try{
            MenuResponse menuResponse=menuItemService.findMenuItemsByCategoryandPrice(category,price);
            return new ResponseEntity(menuResponse,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CREATED);
        }
    }

    // get all non veg foods of a restaurant

    // Get cheapest 5 food items of a partiuclar restaurant

    // Get costliest 5 food items of a partiuclar restaurant

    // Get costliest 5 food items of a partiuclar catgeory -> name fo dish and rest which serves that dish
}
