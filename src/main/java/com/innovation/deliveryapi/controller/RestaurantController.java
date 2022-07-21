package com.innovation.deliveryapi.controller;

import com.innovation.deliveryapi.Dto.RestaurantDto;
import com.innovation.deliveryapi.model.Restaurant;
import com.innovation.deliveryapi.service.RestaurantService;
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
    public Restaurant createRestaurant(@RequestBody RestaurantDto requestDto) {

        return restaurantService.createRestaurant(requestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {
        return restaurantService.getRestaurant();
    }
}
