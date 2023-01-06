package com.bms.weddingorganizationcompanysystem.exception.invoice;

public class InvoiceNotFoundException extends RuntimeException {
    public InvoiceNotFoundException(String message) {
        super(message);
    }
}
