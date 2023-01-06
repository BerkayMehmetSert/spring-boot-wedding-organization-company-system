package com.bms.weddingorganizationcompanysystem.dto;

import java.time.LocalDateTime;

public record LocationEventDto(
        String id,
        String name,
        LocalDateTime startTimePlanned,
        LocalDateTime endTimePlanned,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean budgePlanned,
        String weddingId
) {
}
