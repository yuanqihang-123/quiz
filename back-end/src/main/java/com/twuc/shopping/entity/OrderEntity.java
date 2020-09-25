package com.twuc.shopping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_form")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity ProductEntity;
}

