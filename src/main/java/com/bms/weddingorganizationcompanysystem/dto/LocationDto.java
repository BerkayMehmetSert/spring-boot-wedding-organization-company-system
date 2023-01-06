package com.bms.weddingorganizationcompanysystem.dto;

import java.util.List;

public record LocationDto(
        String id,
        String name,
        String cityId,
        List<LocationEventDto> events
) {
}
