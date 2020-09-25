package com.twuc.shopping.controller;

import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Order;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order/{id}")
    public ResponseEntity addProductToOrder(@PathVariable Integer id){
        orderService.addOrder(id);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/orders")
    public ResponseEntity getOrders(){
       List<OrderEntity> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }
}
