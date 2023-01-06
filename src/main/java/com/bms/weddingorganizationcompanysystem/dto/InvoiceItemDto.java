package com.bms.weddingorganizationcompanysystem.dto;

public record InvoiceItemDto(
        String id,
        String name,
        Double price,
        String invoiceId,
        String employmentIncludeId,
        String productIncludeId
) {
}
