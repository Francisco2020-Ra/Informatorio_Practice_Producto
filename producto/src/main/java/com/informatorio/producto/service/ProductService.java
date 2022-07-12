package com.informatorio.producto.service;

import com.informatorio.producto.dto.ProductDTO;
import com.informatorio.producto.entity.ProductEntity;

public interface ProductService {

    ProductEntity addProduct(ProductDTO productDTO);
}
