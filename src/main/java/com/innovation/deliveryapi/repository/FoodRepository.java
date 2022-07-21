package com.innovation.deliveryapi.repository;

import com.innovation.deliveryapi.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByRestaurantId(Long restaurantId);

    boolean existsByRestaurantIdAndName(Long restaurantId, String name);
}
