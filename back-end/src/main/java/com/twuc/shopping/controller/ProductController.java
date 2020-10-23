package com.twuc.shopping.controller;

import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
       List<ProductEntity> list = productService.getAllProducts();
       return ResponseEntity.ok(list);
    }

    @PostMapping("/product")
    public ResponseEntity addAllProduct(@RequestParam ProductEntity productEntity) {
        String status = productService.save(productEntity);
        if(status=="repeat"){
            return ResponseEntity.ok("repeat");
        }
        return ResponseEntity.ok("success");
    }

}
