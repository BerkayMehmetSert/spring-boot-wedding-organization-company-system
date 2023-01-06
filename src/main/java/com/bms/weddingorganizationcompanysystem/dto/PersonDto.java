package com.bms.weddingorganizationcompanysystem.dto;

import java.util.List;

public record PersonDto(
        String id,
        String personCode,
        String firstName,
        String lastName,
        List<PersonParticipateDto> participates
) {
}
