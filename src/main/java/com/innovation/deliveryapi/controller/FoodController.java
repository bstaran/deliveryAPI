package com.innovation.deliveryapi.controller;

import com.innovation.deliveryapi.Dto.FoodRequestDto;
import com.innovation.deliveryapi.model.Food;
import com.innovation.deliveryapi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(
            @RequestBody List<FoodRequestDto> requestDtoList,
            @PathVariable Long restaurantId
    ) {
        foodService.registerFood(restaurantId, requestDtoList);
//        return list;
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoods(@PathVariable Long restaurantId) {
        return foodService.getFoods(restaurantId);
    }
}
