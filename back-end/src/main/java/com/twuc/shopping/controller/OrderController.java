package com.twuc.shopping.controller;

import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order/{id}")
    public ResponseEntity addProductToOrder(@PathVariable Integer id){
        orderService.addOrder(id);
        return null;
    }
}
