package com.bms.weddingorganizationcompanysystem.request.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseLocationRequest {
    private String name;
    private String cityId;
}
