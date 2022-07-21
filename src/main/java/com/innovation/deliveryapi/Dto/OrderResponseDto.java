package com.innovation.deliveryapi.Dto;

import com.innovation.deliveryapi.model.FoodOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int deliveryFee;
    private int totalPrice;

    public OrderResponseDto(String restaurantName, List<FoodOrderDto> foods, int deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.foods = foods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{" +
                "restaurantName='" + restaurantName + '\'' +
                ", foods=" + foods +
                ", deliveryFee=" + deliveryFee +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
