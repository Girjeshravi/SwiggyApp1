package com.example.FoodDeliveryApp2.dto.request;

import com.example.FoodDeliveryApp2.Enum.RestarauntCategory;
import com.example.FoodDeliveryApp2.Enum.RestarauntCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest {

    String name;

    String location;

    RestarauntCategory restrauntCategory;

    String contactNumber;

}
