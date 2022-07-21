package com.innovation.deliveryapi.repository;

import com.innovation.deliveryapi.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    List<FoodOrder> findAllByOrderRequestId(Long id);
}
