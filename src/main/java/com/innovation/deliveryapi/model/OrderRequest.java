package com.innovation.deliveryapi.model;

import com.innovation.deliveryapi.Dto.OrderDto;
import com.innovation.deliveryapi.Dto.OrderRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrderRequest {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "FOOD_ORDER_ID")
    private Long id;

//    @Column(nullable = false)
//    private Long restaurantId;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    @OneToMany(mappedBy = "orderRequest")
    private List<FoodOrder> foodOrders = new ArrayList<>();

    public OrderRequest(OrderDto orderDto) {
        this.restaurantName = orderDto.getRestaurantName();
        this.deliveryFee = orderDto.getDeliveryFee();
        this.totalPrice = orderDto.getTotalPrice();
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", restaurantName='" + restaurantName + '\'' +
                ", deliveryFee=" + deliveryFee +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
