package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.ProductDto;
import com.bms.weddingorganizationcompanysystem.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDtoConverter {
    private final ProductProductProviderDtoConverter productProductProviderDtoConverter;

    public ProductDtoConverter(ProductProductProviderDtoConverter productProductProviderDtoConverter) {
        this.productProductProviderDtoConverter = productProductProviderDtoConverter;
    }

    public ProductDto convert(Product from) {
        return new ProductDto(
                from.getId(),
                from.getProductCode(),
                from.getName(),
                from.getDescription(),
                from.getPicture(),
                from.getPrice(),
                from.getProductProviders() != null ? productProductProviderDtoConverter.convert(from.getProductProviders()) : null
        );
    }

    public List<ProductDto> convert(List<Product> from) {
        return from.stream().map(this::convert).toList();
    }
}
