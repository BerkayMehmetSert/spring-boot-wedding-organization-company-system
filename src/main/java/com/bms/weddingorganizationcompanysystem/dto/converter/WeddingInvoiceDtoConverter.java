package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.WeddingInvoiceDto;
import com.bms.weddingorganizationcompanysystem.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeddingInvoiceDtoConverter {
    public WeddingInvoiceDto convert(Invoice from) {
        return new WeddingInvoiceDto(
                from.getId(),
                from.getCreatedTime(),
                from.getDueDate(),
                from.getInvoiceAmount(),
                from.getPaymentTime(),
                from.getPaid()
        );
    }

    public List<WeddingInvoiceDto> convert(List<Invoice> from) {
        return from.stream().map(this::convert).toList();
    }
}
