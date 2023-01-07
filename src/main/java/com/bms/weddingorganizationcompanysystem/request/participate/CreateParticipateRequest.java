package com.bms.weddingorganizationcompanysystem.request.participate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateParticipateRequest extends BaseParticipateRequest{
    private String weddingId;
}
