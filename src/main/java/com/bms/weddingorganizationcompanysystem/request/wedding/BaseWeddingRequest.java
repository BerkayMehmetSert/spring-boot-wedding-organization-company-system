package com.bms.weddingorganizationcompanysystem.request.wedding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseWeddingRequest {
    private LocalDateTime startTimePlanned;
    private LocalDateTime endTimePlanned;
    private LocalDateTime startTime;
    private Boolean budgePlanned;

}
