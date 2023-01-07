package com.bms.weddingorganizationcompanysystem.request.invoiceitem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseInvoiceItemRequest {
    private String name;
    private String invoiceId;
    private String employmentIncludeId;
    private String productIncludeId;
}
