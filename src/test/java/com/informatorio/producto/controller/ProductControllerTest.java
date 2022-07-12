package com.informatorio.producto.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.informatorio.producto.dto.ProductDTO;
import com.informatorio.producto.entity.ProductEntity;
import com.informatorio.producto.repository.ProductRepository;
import com.informatorio.producto.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ProductRepository productRepository;

    @Test
    void when_receiveAProductDTO_then_returnProductWithTheId() throws Exception {
        when(productRepository.save(productEntity(null))).thenReturn(productEntity(1L));

        mockMvc.perform(post("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productEntity(1L))))
                .andExpect(jsonPath("$.name", is("Coca Cola")))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void when_receiveAIdProduct_then_returnPrduct() throws Exception {
        when(productRepository.findById(1L)).thenReturn(Optional.of(productEntity(1L)));

        mockMvc.perform(get("/product/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productEntity(1L))))
                .andExpect(jsonPath("$.name", is("Coca Cola")))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void when_getAllProduct_then_returnListProduct() throws Exception {
        List<ProductEntity> productEntityList = Arrays.asList(
                productEntity(1L),
                productEntity(2L),
                productEntity(3L));

        when(productRepository.findAll()).thenReturn(productEntityList);

        mockMvc.perform(
                get("/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(productEntityList))
        )
                .andExpect(jsonPath("$.[0].id", is(1)))
                .andExpect(jsonPath("$.[1].id", is(2)))
                .andExpect(jsonPath("$.[2].id", is(3)));
    }

    @Test
    void when_updateProduct_then_updateProduct() throws Exception {
        when(productRepository.findById(1L)).thenReturn(Optional.of(productEntity(1L)));
        when(productRepository.save(productEntity(1L))).thenReturn(productEntity(1L));

        mockMvc.perform(put("/product/1", productDTO())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productEntity(1L))))
                .andExpect(jsonPath("$.id", is(1)));
    }
    private ProductEntity productEntity(Long id){
        return ProductEntity.builder()
                .id(id)
                .name("Coca Cola")
                .description("Gaseosa")
                .unitPrice(24.5)
                .build();
    }

    private ProductDTO productDTO(){
        return ProductDTO.builder()
                .name("Coca Cola")
                .description("Gaseosa")
                .unitPrice(24.5)
                .build();
    }
}