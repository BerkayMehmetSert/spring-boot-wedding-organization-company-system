package com.bms.weddingorganizationcompanysystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InvoiceDto(
        String id,
        LocalDateTime createdTime,
        LocalDate dueDate,
        Double invoiceAmount,
        LocalDateTime paymentTime,
        Boolean paid,
        String weddingId,
        List<InvoiceInvoiceItemDto> invoiceItems
) {
}
