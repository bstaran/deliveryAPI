package com.innocation.deliveryapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FoodRequestDto {
    private Long restaurantId;
    private String name;
    private int price;

    @Override
    public String toString() {
        return "FoodRequestDto{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
