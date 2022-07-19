package com.innocation.deliveryapi.repository;

import com.innocation.deliveryapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


}
