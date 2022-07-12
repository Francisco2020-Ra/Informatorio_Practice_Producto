package com.informatorio.producto.controller;


import com.informatorio.producto.dto.ProductDTO;
import com.informatorio.producto.exception.ResourceNotFoundException;
import com.informatorio.producto.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebResult;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity(productService.addProduct(productDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductId(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductId(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> udpateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) throws ResourceNotFoundException {
        return new ResponseEntity<>(productService.updateProduct(id, productDTO), HttpStatus.OK);
    }


}
