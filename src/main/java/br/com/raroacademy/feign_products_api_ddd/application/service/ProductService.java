package br.com.raroacademy.feign_products_api_ddd.application.service;

import br.com.raroacademy.feign_products_api_ddd.api.dto.ProductRequestDTO;
import br.com.raroacademy.feign_products_api_ddd.api.dto.ProductResponseDTO;
import br.com.raroacademy.feign_products_api_ddd.exception.ResourceNotFoundException;
import br.com.raroacademy.feign_products_api_ddd.infraestructure.config.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductClient client;

    public ProductService(ProductClient client) {
        this.client = client;
    }

    public List<ProductResponseDTO> getProduct(ProductRequestDTO req) {
        log.info("Método getProduct iniciado");

        long start = System.nanoTime();

        var resp = client.getProductsByCategory(req.getCategory()).getProducts();
        var result = resp.stream()
                .filter(p -> p.getPrice() < req.getPrice())
                .filter(p -> p.getStock() >= req.getStock())
                .collect(Collectors.toList());

        long durationMs = (System.nanoTime() - start) / 1_000_000;
        log.info("⏱️ A pesquisa de produtos levou {} ms", durationMs);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException(
                    String.format("Produtos da %s com estoque ≥ %d e valor < %.2f",
                            req.getCategory(), req.getStock(), req.getPrice()));
        }
        return result;
    }
}
