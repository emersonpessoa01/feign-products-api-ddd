package br.com.raroacademy.feign_products_api_ddd.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raroacademy.feign_products_api_ddd.domain.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
