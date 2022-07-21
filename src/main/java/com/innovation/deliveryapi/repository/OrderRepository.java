package com.innovation.deliveryapi.repository;

import com.innovation.deliveryapi.model.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderRequest, Long> {
}
