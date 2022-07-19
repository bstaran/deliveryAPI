package com.innocation.deliveryapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantRequestDto {

    private String name;
    private int minOrderPrice;
    private int deliveryFee;
}
