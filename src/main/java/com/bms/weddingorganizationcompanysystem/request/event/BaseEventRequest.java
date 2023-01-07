package com.bms.weddingorganizationcompanysystem.request.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEventRequest {
    private String name;
    private LocalDateTime startTimePlanned;
    private LocalDateTime endTimePlanned;
    private Boolean budgePlanned;
    private String locationId;
}
