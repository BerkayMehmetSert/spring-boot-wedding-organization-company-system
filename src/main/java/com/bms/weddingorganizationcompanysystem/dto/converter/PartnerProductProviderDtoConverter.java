package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.PartnerProductProviderDto;
import com.bms.weddingorganizationcompanysystem.model.ProductProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartnerProductProviderDtoConverter {
    public PartnerProductProviderDto convert(ProductProvider from) {
        return new PartnerProductProviderDto(
                from.getId(),
                from.getDetail(),
                from.getIsActive(),
                from.getProduct() != null ? from.getProduct().getId() : null
        );
    }

    public List<PartnerProductProviderDto> convert(List<ProductProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
