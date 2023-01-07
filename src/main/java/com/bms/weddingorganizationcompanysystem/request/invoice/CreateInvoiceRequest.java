package com.bms.weddingorganizationcompanysystem.request.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest extends BaseInvoiceRequest{
    private String weddingId;
}
