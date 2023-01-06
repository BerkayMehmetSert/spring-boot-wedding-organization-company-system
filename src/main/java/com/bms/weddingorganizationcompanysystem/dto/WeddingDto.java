package com.bms.weddingorganizationcompanysystem.dto;

import java.time.LocalDateTime;
import java.util.List;

public record WeddingDto(
        String id,
        String weddingCode,
        LocalDateTime startTimePlanned,
        LocalDateTime endTimePlanned,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean budgePlanned,
        List<WeddingParticipateDto> participates,
        List<WeddingInvoiceDto> invoices
) {
}
