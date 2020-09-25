package com.twuc.shopping.controller;

import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ProductService productService;

    @Test
    public void getAllProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
        List<ProductEntity> all = productService.getAllProducts();
        assertNotNull(all);
        assertEquals(all.size(), 5);
        assertEquals(all.get(0).getName(), "手机");
        assertEquals(all.get(0).getPrice(), 1000);
        assertEquals(all.get(0).getUnit(), "部");
    }
}