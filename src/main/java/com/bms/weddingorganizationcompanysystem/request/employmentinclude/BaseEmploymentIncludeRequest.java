package com.bms.weddingorganizationcompanysystem.request.employmentinclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEmploymentIncludeRequest {
    private Double price;
    private String statusId;
}
