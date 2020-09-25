package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_form")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int price;
    private int count;
    private String unit;

    @ManyToMany
    @JoinTable(name="product_order",joinColumns=@JoinColumn(name="order_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    private List<ProductEntity> ProductEntities;
}

