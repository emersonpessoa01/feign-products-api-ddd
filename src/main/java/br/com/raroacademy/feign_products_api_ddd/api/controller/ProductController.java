package br.com.raroacademy.feign_products_api_ddd.api.controller;

import br.com.raroacademy.feign_products_api_ddd.api.dto.ProductRequestDTO;
import br.com.raroacademy.feign_products_api_ddd.api.dto.ProductResponseDTO;
import br.com.raroacademy.feign_products_api_ddd.application.usecase.FetchProductsByCategoryUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final FetchProductsByCategoryUseCase useCase;

    public ProductController(FetchProductsByCategoryUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<List<ProductResponseDTO>> fetchProducts(
            @Validated @RequestBody ProductRequestDTO req) {

        return ResponseEntity.ok(useCase.execute(req));
    }
}
