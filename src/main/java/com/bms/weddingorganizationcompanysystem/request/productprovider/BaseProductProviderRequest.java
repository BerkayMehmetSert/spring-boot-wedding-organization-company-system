package com.bms.weddingorganizationcompanysystem.request.productprovider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseProductProviderRequest {
    private String detail;
    private String productId;
    private String partnerId;
}
