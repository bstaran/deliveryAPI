package com.innovation.deliveryapi.Dto;

import com.innovation.deliveryapi.model.Foods;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter @Setter
public class OrderRequestDto {
    private Long id;

    private Long restaurantId;

    private List<FoodsDto> foods;
}
