package com.bms.weddingorganizationcompanysystem.dto;

public record ProductProviderDto(
        String id,
        String detail,
        Boolean isActive,
        String productId,
        String partnerId
) {
}
