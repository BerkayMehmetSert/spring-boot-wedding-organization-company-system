package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.InvoiceDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.invoice.CreateInvoiceRequest;
import com.bms.weddingorganizationcompanysystem.request.invoice.UpdateInvoiceRequest;
import com.bms.weddingorganizationcompanysystem.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/v1/invoice")
@Slf4j
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<Void> createInvoice(@RequestBody CreateInvoiceRequest request) {
        invoiceService.createInvoice(request);

        log.info(ControllerLogMessage.Invoice.INVOICE_CREATED + request.getWeddingId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/pdf")
    public ResponseEntity<InputStreamResource> generatePdf(@PathVariable String id) {
        ByteArrayInputStream pdf = invoiceService.generatePdf(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + id + ".pdf");

        log.info(ControllerLogMessage.Invoice.INVOICE_PDF_CREATED + id);
        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInvoice(@PathVariable String id,
                                              @RequestBody UpdateInvoiceRequest request) {
        invoiceService.updateInvoice(id, request);

        log.info(ControllerLogMessage.Invoice.INVOICE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/pay")
    public ResponseEntity<Void> paymentInvoice(@PathVariable String id) {
        invoiceService.paymentInvoice(id);

        log.info(ControllerLogMessage.Invoice.INVOICE_PAID + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable String id) {
        invoiceService.deleteInvoice(id);

        log.info(ControllerLogMessage.Invoice.INVOICE_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> findInvoice(@PathVariable String id) {
        InvoiceDto invoice = invoiceService.findInvoice(id);

        log.info(ControllerLogMessage.Invoice.INVOICE_FOUND + id);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceDto>> findAllInvoices() {
        List<InvoiceDto> invoices = invoiceService.findAllInvoices();

        log.info(ControllerLogMessage.Invoice.INVOICE_LISTED);
        return ResponseEntity.ok(invoices);
    }
}
