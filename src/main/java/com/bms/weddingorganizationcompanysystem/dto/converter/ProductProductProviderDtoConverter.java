package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.ProductProductProviderDto;
import com.bms.weddingorganizationcompanysystem.model.ProductProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProductProviderDtoConverter {
    public ProductProductProviderDto convert(ProductProvider from) {
        return new ProductProductProviderDto(
                from.getId(),
                from.getDetail(),
                from.getIsActive(),
                from.getProduct() != null ? from.getProduct().getId() : null
        );
    }

    public List<ProductProductProviderDto> convert(List<ProductProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
