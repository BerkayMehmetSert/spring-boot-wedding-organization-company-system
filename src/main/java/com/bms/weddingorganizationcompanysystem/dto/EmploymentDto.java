package com.bms.weddingorganizationcompanysystem.dto;

import java.util.List;

public record EmploymentDto(
    String id,
    String serviceCode,
    String serviceName,
    String description,
    String picture,
    List<EmploymentEmploymentProviderDto> employmentProviders
) {
}
