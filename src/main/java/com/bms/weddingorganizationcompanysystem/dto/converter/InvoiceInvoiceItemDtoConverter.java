package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.InvoiceInvoiceItemDto;
import com.bms.weddingorganizationcompanysystem.model.InvoiceItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceInvoiceItemDtoConverter {
    public InvoiceInvoiceItemDto convert(InvoiceItem from) {
        return new InvoiceInvoiceItemDto(
                from.getId(),
                from.getName(),
                from.getPrice(),
                from.getEmploymentInclude() != null ? from.getEmploymentInclude().getId() : null,
                from.getProductInclude() != null ? from.getProductInclude().getId() : null
        );
    }

    public List<InvoiceInvoiceItemDto> convert(List<InvoiceItem> from) {
        return from.stream().map(this::convert).toList();
    }
}
