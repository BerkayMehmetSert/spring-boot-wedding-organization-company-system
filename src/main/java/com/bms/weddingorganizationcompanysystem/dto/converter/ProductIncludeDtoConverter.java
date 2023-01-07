package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.ProductIncludeDto;
import com.bms.weddingorganizationcompanysystem.model.ProductInclude;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductIncludeDtoConverter {
    public ProductIncludeDto convert(ProductInclude from) {
        return new ProductIncludeDto(
                from.getId(),
                from.getPrice(),
                from.getProductProvider() != null ? from.getProductProvider().getId() : null,
                from.getEvent() != null ? from.getEvent().getId() : null,
                from.getStatus() != null ? from.getStatus().getId() : null
        );
    }

    public List<ProductIncludeDto> convert(List<ProductInclude> from) {
        return from.stream().map(this::convert).toList();
    }
}
