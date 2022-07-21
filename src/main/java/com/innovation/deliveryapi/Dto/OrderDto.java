package com.innovation.deliveryapi.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderDto {
    private String restaurantName;
    private int deliveryFee;
    private int totalPrice;

    public OrderDto(String restaurantName, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
