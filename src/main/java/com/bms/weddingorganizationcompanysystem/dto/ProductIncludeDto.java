package com.bms.weddingorganizationcompanysystem.dto;

public record ProductIncludeDto(
        String id,
        Double price,
        String productProviderId,
        String eventId,
        String statusId
) {
}
