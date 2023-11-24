package com.example.FoodDeliveryApp2.dto.request;

import com.example.FoodDeliveryApp2.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuRequest {
    // add foood to menu request
    int restaurantId;

    String dishName;

    double price;

    FoodCategory category;

    boolean veg;

    boolean available;
}
