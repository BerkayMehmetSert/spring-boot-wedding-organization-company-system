package com.bms.weddingorganizationcompanysystem.dto;

public record StatusDto(
        String id,
        String name,
        Boolean offer,
        Boolean offerAccepted,
        Boolean offerRejected
) {
}
