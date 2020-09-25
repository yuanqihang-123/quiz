package com.twuc.shopping.service;

import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        final List<ProductEntity> products = new LinkedList<>();
        Iterable<ProductEntity> all = productRepository.findAll();
                all.forEach(products::add);
        return products;
    }
}
