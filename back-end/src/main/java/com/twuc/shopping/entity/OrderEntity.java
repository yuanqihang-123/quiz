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

//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private ProductEntity ProductEntity;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "order_product",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    private List<ProductEntity> products;
}

