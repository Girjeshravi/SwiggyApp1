package com.example.FoodDeliveryApp2.service;
import com.example.FoodDeliveryApp2.dto.request.MenuRequest;
import com.example.FoodDeliveryApp2.dto.request.RestaurantRequest;
import com.example.FoodDeliveryApp2.dto.response.RestaurantResponse;
import com.example.FoodDeliveryApp2.exception.RestaurantNotFoundException;
import com.example.FoodDeliveryApp2.model.MenuItem;
import com.example.FoodDeliveryApp2.model.Restaurant;
import com.example.FoodDeliveryApp2.repository.RestaurantRespository;
import com.example.FoodDeliveryApp2.transformer.MenuItemTransformer;
import com.example.FoodDeliveryApp2.transformer.RestaurantTransformer;
import com.example.FoodDeliveryApp2.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RestaurantService {
    final RestaurantRespository restaurantRespository;
    final ValidationUtils validationUtils;
    @Autowired
    public RestaurantService(RestaurantRespository restaurantRespository,
                             ValidationUtils validationUtils) {
        this.restaurantRespository = restaurantRespository;
        this.validationUtils = validationUtils;
    }
    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        // dto -> model
        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);
        //persist/save the model in db
        Restaurant savedRestaurant = restaurantRespository.save(restaurant);
        // prepare response dto from model
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
    }

    public String changeOpenedStatus(int id) {

        //check whether id is valid or not
        if(!validationUtils.validateRestaurantId(id)){
            // dont showed to client but in our backend part we can see
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

       // Restaurant restaurant = restaurantRespository.findById(id).get(); // replaced by below line
        Restaurant restaurant = restaurantRespository.findRestaurantById(id);
        restaurant.setOpened(!restaurant.isOpened());
        restaurantRespository.save(restaurant);

        if(restaurant.isOpened()){
            return "Restaurant is opened now!!!";
        }

        return "Restaurant is closed";
    }

    public RestaurantResponse addMenuItemtToRestaurant(MenuRequest menuRequest) {

        // check reataurant is valid or not
        if(!validationUtils.validateRestaurantId(menuRequest.getRestaurantId())){
            throw new RestaurantNotFoundException("Restaurant doesn't exist!!");
        }

        Restaurant restaurant = restaurantRespository.findById(menuRequest.getRestaurantId()).get();
        // make food entity
        MenuItem menuItem = MenuItemTransformer.MenuRequestToMenuItem(menuRequest);
        menuItem.setRestaurant(restaurant);

        restaurant.getAvailableMenuItems().add(menuItem);

        // save rest and food
        Restaurant savedRestaurant = restaurantRespository.save(restaurant);

        // prepare response
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);

    }

    public RestaurantResponse findRestaurantMenuByContactNo(String contactNumber) {
        Restaurant restaurant=restaurantRespository.findRestaurantMenuByContactNumber(contactNumber);
        if(restaurant==null){
            throw new RestaurantNotFoundException("invalid contact number");
        }
        return RestaurantTransformer.RestaurantToRestaurantResponse(restaurant);
    }
}
