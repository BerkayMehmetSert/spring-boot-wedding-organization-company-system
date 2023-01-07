package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.ProductProviderDto;
import com.bms.weddingorganizationcompanysystem.model.ProductProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProviderDtoConverter {
    public ProductProviderDto convert(ProductProvider from) {
        return new ProductProviderDto(
                from.getId(),
                from.getDetail(),
                from.getIsActive(),
                from.getProduct() != null ? from.getProduct().getId() : null,
                from.getPartner() != null ? from.getPartner().getId() : null
        );
    }

    public List<ProductProviderDto> convert(List<ProductProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
