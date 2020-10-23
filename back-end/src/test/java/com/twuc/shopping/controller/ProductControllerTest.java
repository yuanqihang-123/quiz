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

@Test
    public void addProduct() throws Exception {
        mockMvc.perform(post("/product")
                .param("name", "测试")
                .param("price", "11")
                .param("unit", "个")
                .param("url", "https://files.jb51.net/image/msb8001.jpg")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        List<ProductEntity> all = productService.getAllProducts();
        assertNotNull(all);
        assertEquals(all.size(), 6);
        assertEquals(all.get(0).getName(), "手机");
        assertEquals(all.get(0).getPrice(), 1000);
        assertEquals(all.get(0).getUnit(), "部");
    }

}