package br.com.raroacademy.feign_products_api_ddd.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class OrderRequestDTO {
    @NotNull(message = "productId é obrigatório")
    private Integer productId;

    @NotNull(message = "quantity é obrigatória")
    @Min(value = 1, message = "quantity deve ser ao menos 1")
    private Integer quantity;

    @NotBlank(message = "category é obrigatória")
    private String category;

    // getters e setters abreviado

    public @NotNull(message = "productId é obrigatório") Integer getProductId() {
        return productId;
    }

    public void setProductId(@NotNull(message = "productId é obrigatório") Integer productId) {
        this.productId = productId;
    }

    public @NotNull(message = "quantity é obrigatória") @Min(value = 1, message = "quantity deve ser ao menos 1") Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(@NotNull(message = "quantity é obrigatória") @Min(value = 1, message = "quantity deve ser ao menos 1") Integer quantity) {
        this.quantity = quantity;
    }

    public @NotBlank(message = "category é obrigatória") String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "category é obrigatória") String category) {
        this.category = category;
    }
}
