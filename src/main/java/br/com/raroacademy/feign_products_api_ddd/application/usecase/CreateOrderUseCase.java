package br.com.raroacademy.feign_products_api_ddd.application.usecase;

import java.util.Optional;

import br.com.raroacademy.feign_products_api_ddd.infraestructure.config.ProductClient;
import br.com.raroacademy.feign_products_api_ddd.infraestructure.repository.OrderRepository;
import org.springframework.stereotype.Component;

import br.com.raroacademy.feign_products_api_ddd.api.dto.OrderRequestDTO;
import br.com.raroacademy.feign_products_api_ddd.api.dto.ProductResponseDTO;
import br.com.raroacademy.feign_products_api_ddd.domain.model.Order;

@Component
public class CreateOrderUseCase {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    public CreateOrderUseCase(ProductClient productClient, OrderRepository orderRepository) {
        this.productClient = productClient;
        this.orderRepository = orderRepository;
    }

    public Long execute(OrderRequestDTO req) {
        // Buscar os produtos da categoria
        var respList = productClient
                .getProductsByCategory(req.getCategory())
                .getProducts();

        // 🧪 Log dos produtos retornados
        System.out.println("Produtos retornados:");
        respList.forEach(p -> System.out.println(p.getId() + " - " + p.getTitle()));

        // Buscar produto pelo ID
        Optional<ProductResponseDTO> prodOpt = respList.stream()
                .filter(p -> req.getProductId().equals(p.getId()))
                .findFirst();

        if (prodOpt.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }

        var prod = prodOpt.get();

        if (prod.getStock() < req.getQuantity()) {
            throw new RuntimeException("Estoque insuficiente");
        }

        Order order = new Order();
        order.setProductId(prod.getId());
        order.setQuantity(req.getQuantity());
        order.setPrice(prod.getPrice() * req.getQuantity());

        return orderRepository.save(order).getId();
    }

}
