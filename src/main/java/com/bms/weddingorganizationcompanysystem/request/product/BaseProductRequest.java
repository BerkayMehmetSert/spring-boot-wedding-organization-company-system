package com.bms.weddingorganizationcompanysystem.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseProductRequest {
    private String name;
    private String description;
    private String picture;
    private Double price;
}
