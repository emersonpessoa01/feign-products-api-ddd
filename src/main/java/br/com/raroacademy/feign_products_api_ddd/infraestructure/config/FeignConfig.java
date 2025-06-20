package br.com.raroacademy.feign_products_api_ddd.infraestructure.config;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    feign.Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}
