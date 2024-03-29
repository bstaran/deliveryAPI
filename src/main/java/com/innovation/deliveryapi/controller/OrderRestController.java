package com.innovation.deliveryapi.controller;

import com.innovation.deliveryapi.Dto.OrderRequestDto;
import com.innovation.deliveryapi.Dto.OrderResponseDto;
import com.innovation.deliveryapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {
    private final OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
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
