package com.bms.weddingorganizationcompanysystem.request.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCityRequest {
    private String name;
    private String postalCode;
    private String countryId;
}
