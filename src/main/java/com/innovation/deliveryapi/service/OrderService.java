package com.innovation.deliveryapi.service;

import com.innovation.deliveryapi.Dto.*;
import com.innovation.deliveryapi.model.*;
import com.innovation.deliveryapi.repository.FoodOrderRepository;
import com.innovation.deliveryapi.repository.FoodRepository;
import com.innovation.deliveryapi.repository.OrderRepository;
import com.innovation.deliveryapi.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository, FoodRepository foodRepository, FoodOrderRepository foodOrderRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
        this.foodOrderRepository = foodOrderRepository;
    }

    @Transactional
    public OrderResponseDto orderRequest(OrderRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(() ->
                new IllegalArgumentException("id값을 확인해주세요.")
        );

        List<FoodsDto> foodsList = requestDto.getFoods();
        List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
        int totalPrice = restaurant.getDeliveryFee();
        for (FoodsDto foodsDto : foodsList) {
            Foods foods = new Foods(foodsDto);
            Food food = foodRepository.findById(foods.getId()).orElseThrow(() ->
                    new IllegalArgumentException("Order 주문 id를 확인해주세요.")
            );
            food.setRestaurant(restaurant);
            foods.setFood(food);

            if (foods.getQuantity() < 1 || foods.getQuantity() > 100) {
                throw new IllegalArgumentException("수량을 확인해주세요.");
            }

            int price = food.getPrice() * foods.getQuantity();
            totalPrice += price;

            FoodOrderDto foodOrderDto = new FoodOrderDto(food.getName(), foods.getQuantity(), price);

            foodOrderDtoList.add(foodOrderDto);
        }

        if (totalPrice - restaurant.getDeliveryFee() < restaurant.getMinOrderPrice()) {
            throw new IllegalArgumentException("최소 주문 금액보다 적습니다.");
        }

        OrderDto orderDto = new OrderDto(restaurant.getName(), restaurant.getDeliveryFee(), totalPrice);
        OrderRequest orderRequest = new OrderRequest(orderDto);

        for (FoodOrderDto foodOrderDto : foodOrderDtoList) {
            FoodOrder foodOrder = new FoodOrder(foodOrderDto);
            foodOrder.setOrderRequest(orderRequest);
            foodOrderRepository.save(foodOrder);
        }

        orderRepository.save(orderRequest);

        return new OrderResponseDto(restaurant.getName(), foodOrderDtoList, restaurant.getDeliveryFee(), totalPrice);
    }

    @Transactional
    public List<OrderResponseDto> getOrder() {
        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();
        for (OrderRequest orderRequest : orderRepository.findAll()) {

            List<FoodOrder> foodOrders = foodOrderRepository.findAllByOrderRequestId(orderRequest.getId());

            List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
            for (FoodOrder foodOrder : foodOrders) {
                System.out.println(foodOrder.toString());
                FoodOrderDto foodOrderDto = new FoodOrderDto(foodOrder.getName(), foodOrder.getQuantity(), foodOrder.getPrice());
                foodOrderDtoList.add(foodOrderDto);
            }

            OrderResponseDto orderResponseDto = new OrderResponseDto(orderRequest.getRestaurantName(), foodOrderDtoList, orderRequest.getDeliveryFee(), orderRequest.getTotalPrice());

            orderResponseDtoList.add(orderResponseDto);
        }
        return orderResponseDtoList;
    }
}
