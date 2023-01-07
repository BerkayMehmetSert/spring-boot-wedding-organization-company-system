package com.bms.weddingorganizationcompanysystem.request.employmentprovider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEmploymentProviderRequest {
    private String detail;
    private String employmentId;
    private String partnerId;
}
