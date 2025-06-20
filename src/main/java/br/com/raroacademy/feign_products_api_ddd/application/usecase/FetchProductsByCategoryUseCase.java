package br.com.raroacademy.feign_products_api_ddd.application.usecase;

import br.com.raroacademy.feign_products_api_ddd.api.dto.ProductRequestDTO;
import br.com.raroacademy.feign_products_api_ddd.api.dto.ProductResponseDTO;
import br.com.raroacademy.feign_products_api_ddd.application.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchProductsByCategoryUseCase {

    private final ProductService productService;

    public FetchProductsByCategoryUseCase(ProductService productService) {
        this.productService = productService;
    }

    public List<ProductResponseDTO> execute(ProductRequestDTO req) {
        return productService.getProduct(req);
    }
}
