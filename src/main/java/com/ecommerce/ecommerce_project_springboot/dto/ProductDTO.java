package com.ecommerce.ecommerce_project_springboot.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String title;
    private Double price;
    private String image;
    private String description;
    private Boolean featured;
}
