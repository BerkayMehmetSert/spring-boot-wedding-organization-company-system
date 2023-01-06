package com.bms.weddingorganizationcompanysystem.dto;

import java.time.LocalDateTime;
import java.util.List;

public record EventDto(
    String id,
    String name,
    LocalDateTime startTimePlanned,
    LocalDateTime endTimePlanned,
    LocalDateTime startTime,
    LocalDateTime endTime,
    Boolean budgePlanned,
    String locationId,
    String weddingId,
    List<EventInEventDto> inEvents
) {
}
