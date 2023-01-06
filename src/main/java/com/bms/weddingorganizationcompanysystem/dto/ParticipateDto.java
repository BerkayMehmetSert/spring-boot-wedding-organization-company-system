package com.bms.weddingorganizationcompanysystem.dto;

public record ParticipateDto(
        String id,
        String weddingId,
        String personId,
        String roleId
) {
}
