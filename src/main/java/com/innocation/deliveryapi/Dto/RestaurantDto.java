package com.innocation.deliveryapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantDto {

    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
