package com.bms.weddingorganizationcompanysystem.request.inevent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateInEventRequest extends BaseInEventRequest{
    private String eventId;
    private String participateId;
}
