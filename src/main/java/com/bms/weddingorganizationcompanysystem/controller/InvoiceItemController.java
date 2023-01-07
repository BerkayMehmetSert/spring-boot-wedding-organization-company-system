package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.InvoiceItemDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.invoiceitem.CreateInvoiceItemRequest;
import com.bms.weddingorganizationcompanysystem.request.invoiceitem.UpdateInvoiceItemRequest;
import com.bms.weddingorganizationcompanysystem.service.InvoiceItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoice-item")
@Slf4j
public class InvoiceItemController {
    private final InvoiceItemService invoiceItemService;

    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }

    @PostMapping
    public ResponseEntity<Void> createInvoiceItem(@RequestBody CreateInvoiceItemRequest request) {
        invoiceItemService.createInvoiceItem(request);

        log.info(ControllerLogMessage.InvoiceItem.INVOICE_ITEM_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInvoiceItem(@PathVariable String id,
                                                  @RequestBody UpdateInvoiceItemRequest request) {
        invoiceItemService.updateInvoiceItem(id, request);

        log.info(ControllerLogMessage.InvoiceItem.INVOICE_ITEM_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoiceItem(@PathVariable String id) {
        invoiceItemService.deleteInvoiceItem(id);

        log.info(ControllerLogMessage.InvoiceItem.INVOICE_ITEM_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItemDto> findInvoiceItem(@PathVariable String id) {
        InvoiceItemDto invoiceItem = invoiceItemService.findInvoiceItem(id);

        log.info(ControllerLogMessage.InvoiceItem.INVOICE_ITEM_FOUND + id);
        return ResponseEntity.ok(invoiceItem);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceItemDto>> findAllInvoiceItems() {
        List<InvoiceItemDto> invoiceItems = invoiceItemService.findAllInvoiceItems();

        log.info(ControllerLogMessage.InvoiceItem.INVOICE_ITEM_LISTED);
        return ResponseEntity.ok(invoiceItems);
    }
}
