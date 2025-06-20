package br.com.raroacademy.feign_products_api_ddd.api.controller;

import br.com.raroacademy.feign_products_api_ddd.api.dto.OrderRequestDTO;
import br.com.raroacademy.feign_products_api_ddd.application.usecase.CreateOrderUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final CreateOrderUseCase useCase;

    public OrderController(CreateOrderUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(
            @Validated @RequestBody OrderRequestDTO req) {
        Long orderId = useCase.execute(req);
        return ResponseEntity.ok().body(
                List.of(Map.of("orderId", orderId))
        );
    }
}