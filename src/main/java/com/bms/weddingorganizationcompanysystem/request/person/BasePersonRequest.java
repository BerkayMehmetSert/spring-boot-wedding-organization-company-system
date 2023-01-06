package com.bms.weddingorganizationcompanysystem.request.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePersonRequest {
    private String firstName;
    private String lastName;
}
