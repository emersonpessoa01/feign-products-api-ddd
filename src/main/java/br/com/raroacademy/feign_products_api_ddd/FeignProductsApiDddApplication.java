package br.com.raroacademy.feign_products_api_ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "br.com.raroacademy.feign_products_api_ddd.infraestructure.config")
public class FeignProductsApiDddApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignProductsApiDddApplication.class, args);
	}
}
