package com.informatorio.producto.service.impl;

import com.informatorio.producto.dto.ProductDTO;
import com.informatorio.producto.entity.ProductEntity;
import com.informatorio.producto.exception.ResourceNotFoundException;
import com.informatorio.producto.mapper.ProductMapper;
import com.informatorio.producto.repository.ProductRepository;
import com.informatorio.producto.service.ProductService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ProductDTO addProduct(ProductDTO productDTO) {
        ProductEntity productEntity = productMapper.toEntity(productDTO);
        ProductEntity productEntity1 = productRepository.save(productEntity);
        return productMapper.toDTO(productEntity1);
    }

    @Override
    public ProductDTO getProductId(Long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        return productMapper.toDTO(productEntity);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductEntity> listProductEntity = productRepository.findAll();
        List<ProductDTO> listProductDTO = productMapper.toListProductDTO(listProductEntity);
        return listProductDTO;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) throws ResourceNotFoundException {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found Product id: " + id));
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setUnitPrice(productDTO.getUnitPrice());
        ProductEntity productEntity1 = productRepository.save(productEntity);

        return productMapper.toDTO(productEntity1);
    }
}
