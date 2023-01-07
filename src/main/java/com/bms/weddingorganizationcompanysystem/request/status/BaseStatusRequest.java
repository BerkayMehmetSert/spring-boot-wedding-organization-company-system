package com.bms.weddingorganizationcompanysystem.request.status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseStatusRequest {
    private String name;
    private Boolean offer;
    private Boolean offerAccepted;
    private Boolean offerRejected;
}
