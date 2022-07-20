package com.innocation.deliveryapi.model;

import com.innocation.deliveryapi.Dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Long restaurantId;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int price;

    public Food(FoodRequestDto requestDto) {
        this.restaurantId = requestDto.getRestaurantId();
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }

}
