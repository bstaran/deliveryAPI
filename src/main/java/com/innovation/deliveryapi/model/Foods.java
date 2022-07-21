package com.innovation.deliveryapi.model;

import com.innovation.deliveryapi.Dto.FoodsDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Foods {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn
    private Food food;

    @Column(nullable = false)
    private int quantity;


    public Foods(FoodsDto foodsDto) {
        this.id = foodsDto.getId();
        this.quantity = foodsDto.getQuantity();
    }
}
