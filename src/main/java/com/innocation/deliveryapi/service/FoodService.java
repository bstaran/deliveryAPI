package com.innocation.deliveryapi.service;

import com.innocation.deliveryapi.Dto.FoodRequestDto;
import com.innocation.deliveryapi.model.Food;
import com.innocation.deliveryapi.model.Restaurant;
import com.innocation.deliveryapi.repository.FoodRepository;
import com.innocation.deliveryapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public Food registerFood(Long restaurantId, FoodRequestDto requestDto) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() ->
                new IllegalArgumentException("음식점 id값을 확인해주세요.")
        );
        Food food = new Food(requestDto);

        if (food.getPrice() < 100 && food.getPrice() > 1000000) {
            throw new IllegalArgumentException("100원 ~ 1,000,000원 사이로 입력해주세요");
        } else if (food.getPrice() % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해주세요.");
        }

        food.setRestaurant(restaurant);
//        food.setRestaurantId(restaurantId);


        foodRepository.save(food);
        return food;
    }

    public List<Food> getFoods(Long restaurantId) {
        return foodRepository.findAllByRestaurantId(restaurantId);
    }
}
