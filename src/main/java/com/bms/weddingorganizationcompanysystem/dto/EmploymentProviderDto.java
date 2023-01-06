package com.bms.weddingorganizationcompanysystem.dto;

public record EmploymentProviderDto (
    String id,
    String detail,
    Boolean isActive,
    String employmentId,
    String partnerId
){
}
