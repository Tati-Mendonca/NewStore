package com.ecommerce.ecommerce_project_springboot.service;

import com.ecommerce.ecommerce_project_springboot.dto.ProductRequestDTO;
import com.ecommerce.ecommerce_project_springboot.dto.ProductResponseDTO;
import com.ecommerce.ecommerce_project_springboot.entity.ProductEntity;
import com.ecommerce.ecommerce_project_springboot.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductResponseDTO create(ProductRequestDTO requestDTO){
        this.productRepository.findByTitle(requestDTO.getTitle())
                .ifPresent((product) -> {
                    throw new RuntimeException("Produto já cadastrado!");
                });
        ProductEntity productEntity = modelMapper.map(requestDTO, ProductEntity.class);
        ProductEntity savedProduct = productRepository.save(productEntity);
        return modelMapper.map(savedProduct, ProductResponseDTO.class);
    }

    public List<ProductResponseDTO> getListProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
         return productEntities.stream()
                 .map(product -> modelMapper.map(product, ProductResponseDTO.class))
                 .collect(Collectors.toList());
    }

    public ProductResponseDTO productById(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        return modelMapper.map(productEntity, ProductResponseDTO.class);
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO requestDTO){
        if (requestDTO.getTitle() == null || requestDTO.getPrice() == null){
            throw new RuntimeException("Verifique se todos os dados foram preenchidos e tente novamente!");
        }
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        modelMapper.map(requestDTO, productEntity);
        ProductEntity updatedProduct = productRepository.save(productEntity);
        return modelMapper.map(updatedProduct, ProductResponseDTO.class);
    }

    public ProductResponseDTO deleteProduct(Long id){
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
                    productRepository.deleteById(id);
        return modelMapper.map(productEntity, ProductResponseDTO.class);
    }
}
