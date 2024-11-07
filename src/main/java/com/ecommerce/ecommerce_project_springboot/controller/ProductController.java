package com.ecommerce.ecommerce_project_springboot.controller;

import com.ecommerce.ecommerce_project_springboot.entity.ProductEntity;
import com.ecommerce.ecommerce_project_springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Object> createProduct(@RequestBody ProductEntity productEntity){
       try {
           var result = this.productService.create(productEntity);
           return ResponseEntity.ok().body(result);
       } catch (Exception e) {
          return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}
