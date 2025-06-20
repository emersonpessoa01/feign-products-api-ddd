package br.com.raroacademy.feign_products_api_ddd.infraestructure.scheduler;

import br.com.raroacademy.feign_products_api_ddd.domain.model.Order;
import br.com.raroacademy.feign_products_api_ddd.infraestructure.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderScheduler {

    private static final Logger log = LoggerFactory.getLogger(OrderScheduler.class);
    private final OrderRepository orderRepository;

    public OrderScheduler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Scheduled(fixedRate = 10000)
    public void reportTotalOrders() {
        double total = orderRepository.findAll()
            .stream()
            .mapToDouble(Order::getPrice)
            .sum();


        log.info("💰 Total de todos os pedidos: {}", total);
    }
}