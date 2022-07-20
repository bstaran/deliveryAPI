package com.innocation.deliveryapi.repository;

import com.innocation.deliveryapi.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByRestaurantId(Long restaurantId);

    boolean existsByRestaurantIdAndName(Long restaurantId, String name);
}
