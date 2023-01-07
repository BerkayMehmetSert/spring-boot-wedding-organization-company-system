package com.bms.weddingorganizationcompanysystem.request.productinclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseProductIncludeRequest {
    private Double price;
    private String statusId;

}
