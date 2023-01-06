package com.bms.weddingorganizationcompanysystem.dto;

import java.util.List;

public record ProductDto(
        String id,
        String productCode,
        String name,
        String description,
        String picture,
        Double price,
        List<ProductProductProviderDto> productProviders
) {
}
