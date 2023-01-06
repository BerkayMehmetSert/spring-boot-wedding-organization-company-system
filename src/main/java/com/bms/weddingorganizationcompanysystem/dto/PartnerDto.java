package com.bms.weddingorganizationcompanysystem.dto;

import java.util.List;

public record PartnerDto(
        String id,
        String partnerCode,
        String name,
        List<PartnerEmploymentProviderDto> employmentProviders,
        List<PartnerProductProviderDto> productProviders
) {
}
