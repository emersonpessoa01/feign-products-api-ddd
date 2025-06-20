package br.com.raroacademy.feign_products_api_ddd.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {

        super(message);
    }
}

