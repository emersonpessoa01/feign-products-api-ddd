package br.com.raroacademy.feign_products_api_ddd.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ProductRequestDTO {
    @NotNull(message = "Preço é obrigatório")
    @Min(value = 0, message = "Preço deve ser positivo")
    private Double price;

    @NotNull(message = "Estoque é obrigatório")
    @Min(value = 0, message = "Estoque deve ser positivo")
    private Integer stock;

    @Setter
    @Getter
    @NotBlank(message = "Categoria é obrigatória")
    private String category;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
