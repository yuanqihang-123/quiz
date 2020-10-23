package com.twuc.shopping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
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

//    @OneToMany(mappedBy = "ProductEntity")
//    private List<OrderEntity> orders;

    @ManyToMany(mappedBy = "products")
    public List<OrderEntity> orders;

    @JsonIgnore
    public List<OrderEntity> getOrders() {
        return orders;
    }

    @JsonProperty
    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }
}
