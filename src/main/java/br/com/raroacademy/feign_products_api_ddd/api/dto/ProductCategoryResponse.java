package br.com.raroacademy.feign_products_api_ddd.api.dto;

import java.util.List;

public class ProductCategoryResponse {
    private List<ProductResponseDTO> products;
    private int total;
    private int skip;
    private int limit;

    // getters e setters
    public List<ProductResponseDTO> getProducts() {
        return products;
    }
    public void setProducts(List<ProductResponseDTO> products) {
        this.products = products;
    }
}
