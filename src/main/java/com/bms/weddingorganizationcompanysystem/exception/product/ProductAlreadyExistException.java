package com.bms.weddingorganizationcompanysystem.exception.product;

public class ProductAlreadyExistException extends RuntimeException {
    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
