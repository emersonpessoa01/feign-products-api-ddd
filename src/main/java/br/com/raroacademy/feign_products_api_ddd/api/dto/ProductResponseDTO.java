package br.com.raroacademy.feign_products_api_ddd.api.dto;

import lombok.*;

@Data
public class ProductResponseDTO {
    private int id;
    private String title;
    private String description;
    private double price;
    private double rating;
    private int stock;
    private String brand;
    private String category;

    // Getters e setters omitidos por brevidade

}

