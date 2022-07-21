package com.innovation.deliveryapi.controller;

import com.innovation.deliveryapi.Dto.OrderDto;
import com.innovation.deliveryapi.Dto.OrderRequestDto;
import com.innovation.deliveryapi.Dto.OrderResponseDto;
import com.innovation.deliveryapi.model.OrderRequest;
import com.innovation.deliveryapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public @ResponseBody OrderResponseDto orderRequest(
            @RequestBody OrderRequestDto requestDto) {

        return orderService.orderRequest(requestDto);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrder() {
        return orderService.getOrder();
    }
}
