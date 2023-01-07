package com.bms.weddingorganizationcompanysystem.request.employmentinclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmploymentIncludeRequest extends BaseEmploymentIncludeRequest {
    private String eventId;
    private String employmentProviderId;
}
