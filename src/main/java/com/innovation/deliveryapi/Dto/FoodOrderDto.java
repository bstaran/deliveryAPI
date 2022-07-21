package com.innovation.deliveryapi.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FoodOrderDto {
    String name;
    int quantity;
    int price;

    public FoodOrderDto(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
