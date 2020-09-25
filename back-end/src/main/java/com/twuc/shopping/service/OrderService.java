package com.twuc.shopping.service;

import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    public void addOrder(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        OrderEntity build = OrderEntity.builder().ProductEntity(productEntity).build();
        orderRepository.save(build);
    }
}
