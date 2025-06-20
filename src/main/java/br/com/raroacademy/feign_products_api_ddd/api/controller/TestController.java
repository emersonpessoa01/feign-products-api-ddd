package br.com.raroacademy.feign_products_api_ddd.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/ping")
    public String ping() {

        return "API está em execução";
    }
}

