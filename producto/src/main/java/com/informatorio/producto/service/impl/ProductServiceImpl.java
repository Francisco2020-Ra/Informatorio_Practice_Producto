package com.informatorio.producto.service.impl;

import com.informatorio.producto.dto.ProductDTO;
import com.informatorio.producto.entity.ProductEntity;
import com.informatorio.producto.mapper.ProductMapper;
import com.informatorio.producto.repository.ProductRepository;
import com.informatorio.producto.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductEntity addProduct(ProductDTO productDTO) {
        ProductEntity productEntity = productMapper.toEntity(productDTO);
        return productRepository.save(productEntity);
    }
}
