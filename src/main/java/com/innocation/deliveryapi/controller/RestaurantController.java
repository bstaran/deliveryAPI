package com.innocation.deliveryapi.controller;

import com.innocation.deliveryapi.Dto.RestaurantRequestDto;
import com.innocation.deliveryapi.model.Restaurant;
import com.innocation.deliveryapi.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant/register")
    public Long createRestaurant(@RequestBody RestaurantRequestDto requestDto) {

        Restaurant restaurant = restaurantService.createRestaurant(requestDto);
        return restaurant.getId();
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {
        return restaurantService.getRestaurant();
    }
}
