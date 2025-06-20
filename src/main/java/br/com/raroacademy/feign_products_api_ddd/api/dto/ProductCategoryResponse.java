package br.com.raroacademy.feign_products_api_ddd.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ProductCategoryResponse {
    // getters e setters
    @Setter
    @Getter
    private List<ProductResponseDTO> products;
    private int total;
    private int skip;
    private int limit;

}
