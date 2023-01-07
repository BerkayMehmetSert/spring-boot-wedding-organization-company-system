package com.bms.weddingorganizationcompanysystem.request.productinclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductIncludeRequest extends BaseProductIncludeRequest {
    private String eventId;
    private String productProviderId;
}
