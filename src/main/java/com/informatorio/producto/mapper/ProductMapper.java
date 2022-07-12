package com.informatorio.producto.mapper;

import com.informatorio.producto.dto.ProductDTO;
import com.informatorio.producto.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductEntity toEntity (ProductDTO productDTO){
        return ProductEntity.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .unitPrice(productDTO.getUnitPrice())
                .build();
    }

    public ProductDTO toDTO(ProductEntity productEntity){
        return ProductDTO.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .build();
    }
}
