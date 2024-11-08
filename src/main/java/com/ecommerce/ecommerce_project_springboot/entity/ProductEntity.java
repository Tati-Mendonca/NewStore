package com.ecommerce.ecommerce_project_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String color;

    @NotBlank(message = "Obrigatório o preenchimento do campo [title]")
    @Column(unique = true)
    private String title;

    @NotNull(message = "Obrigatório o preenchimento do campo [price]")
    private Double price;

    @NotNull(message = "Obrigatório o preenchimento do campo [featured]")
    private Boolean featured;

    private String image;
    private String description;

}
