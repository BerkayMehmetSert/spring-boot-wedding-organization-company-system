package com.bms.weddingorganizationcompanysystem.request.employment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEmploymentRequest {
    private String serviceName;

    private String description;

    private String picture;
}
