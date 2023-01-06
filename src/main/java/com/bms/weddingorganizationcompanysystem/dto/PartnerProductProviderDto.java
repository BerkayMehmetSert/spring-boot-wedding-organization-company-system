package com.bms.weddingorganizationcompanysystem.dto;

public record PartnerProductProviderDto(
        String id,
        String detail,
        Boolean isActive,
        String productId
) {
}
