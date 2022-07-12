package com.informatorio.producto.service;

import com.informatorio.producto.dto.ProductDTO;
import com.informatorio.producto.entity.ProductEntity;
import com.informatorio.producto.exception.ResourceNotFoundException;

import java.util.List;

public interface ProductService {

    ProductDTO addProduct(ProductDTO productDTO);

    ProductDTO getProductId(Long id);

    List<ProductDTO> getAllProduct();

    ProductDTO updateProduct(Long id, ProductDTO productDTO) throws ResourceNotFoundException;
}
