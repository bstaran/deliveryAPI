package com.innovation.deliveryapi.model;

import com.innovation.deliveryapi.Dto.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class FoodOrder {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "FOOD_ORDER_ID")
    private OrderRequest orderRequest;

    public FoodOrder(FoodOrderDto foodOrderDto) {
        this.name = foodOrderDto.getName();
        this.quantity = foodOrderDto.getQuantity();
        this.price = foodOrderDto.getPrice();
    }

    @Override
    public String toString() {
        return "FoodOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderRequest=" + orderRequest +
                '}';
    }
}
