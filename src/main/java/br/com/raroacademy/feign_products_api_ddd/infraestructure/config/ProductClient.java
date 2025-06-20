package br.com.raroacademy.feign_products_api_ddd.infraestructure.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.raroacademy.feign_products_api_ddd.api.dto.ProductCategoryResponse;

@FeignClient(name = "productClient", url = "https://dummyjson.com")
public interface ProductClient {

    @GetMapping("/products/category/{category}")
    ProductCategoryResponse getProductsByCategory(@PathVariable("category") String category);
}
