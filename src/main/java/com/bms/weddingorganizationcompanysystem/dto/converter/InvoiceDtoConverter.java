package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.InvoiceDto;
import com.bms.weddingorganizationcompanysystem.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceDtoConverter {
    private final InvoiceInvoiceItemDtoConverter invoiceInvoiceItemDtoConverter;

    public InvoiceDtoConverter(InvoiceInvoiceItemDtoConverter invoiceInvoiceItemDtoConverter) {
        this.invoiceInvoiceItemDtoConverter = invoiceInvoiceItemDtoConverter;
    }

    public InvoiceDto convert(Invoice from) {
        return new InvoiceDto(
                from.getId(),
                from.getCreatedTime(),
                from.getDueDate(),
                from.getInvoiceAmount(),
                from.getPaymentTime(),
                from.getPaid(),
                from.getWedding() != null ? from.getWedding().getId() : null,
                from.getInvoiceItems() != null ? invoiceInvoiceItemDtoConverter.convert(from.getInvoiceItems()) : null
        );
    }

    public List<InvoiceDto> convert(List<Invoice> from) {
        return from.stream().map(this::convert).toList();
    }
}
