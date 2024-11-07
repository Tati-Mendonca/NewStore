package com.ecommerce.ecommerce_project_springboot.repository;

import com.ecommerce.ecommerce_project_springboot.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByTitle(String Title);
}
