package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int price;
    private String unit;
    private String url;

    @ManyToMany(mappedBy = "ProductEntities")
    private List<OrderEntity> orders;
}
