package com.example.FoodDeliveryApp2.repository;

import com.example.FoodDeliveryApp2.Enum.FoodCategory;
import com.example.FoodDeliveryApp2.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {


    public MenuItem findMenuItemsByCategory(FoodCategory category);



//    " select * from menu where FoodCategory is category and price is > foodprice ";
//    @Query(value="select * from menu where FoodCategory is category and price is > foodprice ")
//    public MenuItem findBycategoryandPrice(FoodCategory category,double foodprice);

    @Query(value="select * from menu where foodCategory = 'scategory' and price is > foodprice ",nativeQuery = true)
    public MenuItem findMenuItemsByCategoryandPrice(FoodCategory scategory, double foodprice);

    MenuItem findMenuItemsByVeg(boolean veg);
}
