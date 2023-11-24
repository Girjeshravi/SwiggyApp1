package com.example.FoodDeliveryApp2.dto.response;

import com.example.FoodDeliveryApp2.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponse {

    String dishName;

    double price;

    FoodCategory category;

    boolean veg;

    int quantityAdded;
}
