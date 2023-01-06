package com.bms.weddingorganizationcompanysystem.dto;

public record InvoiceInvoiceItemDto(
        String id,
        String name,
        Double price,
        String employmentIncludeId,
        String productIncludeId
) {
}
