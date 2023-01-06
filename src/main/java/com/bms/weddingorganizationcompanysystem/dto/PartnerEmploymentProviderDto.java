package com.bms.weddingorganizationcompanysystem.dto;

public record PartnerEmploymentProviderDto(
        String id,
        String detail,
        Boolean isActive,
        String employmentId
) {
}
