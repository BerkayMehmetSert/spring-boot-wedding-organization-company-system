package com.bms.weddingorganizationcompanysystem.dto;

public record EmploymentIncludeDto(
        String id,
        Double price,
        String statusId,
        String eventId,
        String employmentProviderId
) {
}
