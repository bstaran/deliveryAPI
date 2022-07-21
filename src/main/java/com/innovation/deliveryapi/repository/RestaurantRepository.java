package com.innovation.deliveryapi.repository;

import com.innovation.deliveryapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
