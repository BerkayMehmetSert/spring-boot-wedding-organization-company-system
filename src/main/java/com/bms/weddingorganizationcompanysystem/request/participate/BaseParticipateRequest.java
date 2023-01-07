package com.bms.weddingorganizationcompanysystem.request.participate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseParticipateRequest {
    private String personId;
    private String roleId;
}
