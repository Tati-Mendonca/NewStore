package com.ecommerce.ecommerce_project_springboot.service;

import com.ecommerce.ecommerce_project_springboot.entity.ProductEntity;
import com.ecommerce.ecommerce_project_springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity create(ProductEntity productEntity){
        this.productRepository.findByTitle(productEntity.getTitle())
                .ifPresent((product) -> {
                    throw new RuntimeException("Produto já cadastrado!");
                });
        return productRepository.save(productEntity);
    }
}
