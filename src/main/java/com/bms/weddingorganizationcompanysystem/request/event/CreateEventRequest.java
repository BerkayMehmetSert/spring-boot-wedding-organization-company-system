package com.bms.weddingorganizationcompanysystem.request.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest extends BaseEventRequest{
    private String weddingId;
}
