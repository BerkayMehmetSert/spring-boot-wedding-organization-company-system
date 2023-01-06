package com.bms.weddingorganizationcompanysystem.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record WeddingInvoiceDto(
        String id,
        LocalDateTime createdTime,
        LocalDate dueDate,
        Double invoiceAmount,
        LocalDateTime paymentTime,
        Boolean paid
) {
}
