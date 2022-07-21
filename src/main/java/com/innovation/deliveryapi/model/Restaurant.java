package com.innovation.deliveryapi.model;

import com.innovation.deliveryapi.Dto.RestaurantDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    @JoinColumn
    @ManyToOne
    private OrderRequest orderRequest;

    public Restaurant(RestaurantDto requestDto) {
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minOrderPrice=" + minOrderPrice +
                ", deliveryFee=" + deliveryFee +
                '}';
    }
}
