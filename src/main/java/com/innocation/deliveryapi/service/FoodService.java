package com.innocation.deliveryapi.service;

import com.innocation.deliveryapi.Dto.FoodRequestDto;
import com.innocation.deliveryapi.model.Food;
import com.innocation.deliveryapi.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food registerFood(Long restaurantId, FoodRequestDto requestDto) {

        Food food = new Food(requestDto);

        if (food.getPrice() < 100 && food.getPrice() > 1000000) {
            throw new IllegalArgumentException("100원 ~ 1,000,000원 사이로 입력해주세요");
        } else if (food.getPrice() % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해주세요.");
        }

        food.setRestaurantId(restaurantId);

        foodRepository.save(food);
        return food;
    }
}
