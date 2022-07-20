package com.innocation.deliveryapi.service;

import com.innocation.deliveryapi.Dto.FoodRequestDto;
import com.innocation.deliveryapi.model.Food;
import com.innocation.deliveryapi.model.Restaurant;
import com.innocation.deliveryapi.repository.FoodRepository;
import com.innocation.deliveryapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void registerFood(Long restaurantId, List<FoodRequestDto> requestDtoList) {
        for (FoodRequestDto requestDto : requestDtoList) {

            Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() ->
                    new IllegalArgumentException("음식점 id값을 확인해주세요.")
            );
            Food food = new Food(requestDto);

            if (foodRepository.existsByRestaurantIdAndName(restaurantId, food.getName())) {
                throw new IllegalArgumentException("중복된 메뉴입니다.");
            }

            if (food.getPrice() < 100 || food.getPrice() > 1000000) {
                throw new IllegalArgumentException("100원 ~ 1,000,000원 사이로 입력해주세요");
            } else if (food.getPrice() % 100 != 0) {
                throw new IllegalArgumentException("100원 단위로 입력해주세요.");
            }
            food.setRestaurant(restaurant);

            foodRepository.save(food);
        }
    }

    public List<Food> getFoods(Long restaurantId) {
        return foodRepository.findAllByRestaurantId(restaurantId);
    }
}
