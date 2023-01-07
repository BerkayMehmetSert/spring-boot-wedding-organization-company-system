package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.InvoiceItemDto;
import com.bms.weddingorganizationcompanysystem.model.InvoiceItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceItemDtoConverter {
    public InvoiceItemDto convert(InvoiceItem from) {
        return new InvoiceItemDto(
                from.getId(),
                from.getName(),
                from.getPrice(),
                from.getInvoice() != null ? from.getInvoice().getId() : null,
                from.getEmploymentInclude() != null ? from.getEmploymentInclude().getId() : null,
                from.getProductInclude() != null ? from.getProductInclude().getId() : null
        );
    }

    public List<InvoiceItemDto> convert(List<InvoiceItem> from) {
        return from.stream().map(this::convert).toList();
    }
}