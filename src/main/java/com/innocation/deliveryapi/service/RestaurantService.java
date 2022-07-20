package com.innocation.deliveryapi.service;

import com.innocation.deliveryapi.Dto.RestaurantRequestDto;
import com.innocation.deliveryapi.model.Restaurant;
import com.innocation.deliveryapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(RestaurantRequestDto requestDto) {

        Restaurant restaurant = new Restaurant(requestDto);

        // 최소 주문가격 검사
        if (restaurant.getMinOrderPrice() < 1000 && restaurant.getMinOrderPrice() > 100000) {
            throw new IllegalArgumentException("유효하지 않은 가격입니다." +
                    "1,000원 ~ 100,000원 사이로 입력해주세요.");
        } else if (restaurant.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해주세요.");
        }

        // 기본 배달비 검사
        if (restaurant.getDeliveryFee() < 0 && restaurant.getDeliveryFee() >= 10000) {
            throw new IllegalArgumentException("유효하지 않은 가격입니다." +
                    "10000원 아래로 입력해주세요.");
        } else if (restaurant.getDeliveryFee() % 500 != 0) {
            throw new IllegalArgumentException("500원 단위로 입력해주세요.");
        }

        restaurantRepository.save(restaurant);

        return restaurant;
    }


    public List<Restaurant> getRestaurant() {
        return restaurantRepository.findAll();
    }
}
