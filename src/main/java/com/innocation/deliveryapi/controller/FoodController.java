package com.innocation.deliveryapi.controller;

import com.innocation.deliveryapi.Dto.FoodRequestDto;
import com.innocation.deliveryapi.model.Food;
import com.innocation.deliveryapi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public Long registerFood(@RequestBody List<FoodRequestDto> requestDtoList,
                             @PathVariable Long restaurantId) {
        for(FoodRequestDto requestDto : requestDtoList){
//            System.out.println(requestDto.toString());
            foodService.registerFood(restaurantId, requestDto);
        }
        System.out.println(restaurantId);

        return 1L;
    }
}
