package com.informatorio.producto.controller;

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