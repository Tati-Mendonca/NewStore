package com.ecommerce.ecommerce_project_springboot.controller;

import com.ecommerce.ecommerce_project_springboot.dto.ProductRequestDTO;
import com.ecommerce.ecommerce_project_springboot.dto.ProductResponseDTO;
import com.ecommerce.ecommerce_project_springboot.service.ProductService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @ApiResponse(responseCode = "200", description = "Produto criado com sucesso!")
    @PostMapping("/")
    public ResponseEntity<Object> createProduct(@RequestBody ProductRequestDTO requestDTO) {
        try {
            ProductResponseDTO responseDTO = productService.create(requestDTO);
            return ResponseEntity.ok().body(responseDTO);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>>listProducts(){
         try{
             List<ProductResponseDTO> responseDTOS = productService.getListProducts();
             return ResponseEntity.ok(responseDTOS);
         } catch (RuntimeException e){
             throw new RuntimeException("Nenhum produto encontrado!");
         }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){
        try{
            ProductResponseDTO responseDTO = productService.productById(id);
            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e){
            throw new RuntimeException( e.getMessage(), e);
        }
    }

    @ApiResponse(responseCode = "400", description = "Verifique se todos os dados foram preenchidos e tente novamente!")
    @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso!")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO productRequestDTO){
        try{
            ProductResponseDTO responseDTO = productService.updateProduct(id, productRequestDTO);
            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e){
            throw new RuntimeException( e.getMessage(), e);
        }
    };

    @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso!")
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> deletePost(@PathVariable Long id){
            productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}


