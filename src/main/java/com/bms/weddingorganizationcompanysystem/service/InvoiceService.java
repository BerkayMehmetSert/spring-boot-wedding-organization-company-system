package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.InvoiceDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.InvoiceDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.inevent.InEventNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.DateHelper;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Invoice;
import com.bms.weddingorganizationcompanysystem.model.InvoiceItem;
import com.bms.weddingorganizationcompanysystem.repository.InvoiceRepository;
import com.bms.weddingorganizationcompanysystem.request.invoice.CreateInvoiceRequest;
import com.bms.weddingorganizationcompanysystem.request.invoice.UpdateInvoiceRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
@Slf4j
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final WeddingService weddingService;
    private final PdfService pdfService;
    private final InvoiceDtoConverter converter;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          WeddingService weddingService,
                          PdfService pdfService,
                          InvoiceDtoConverter converter) {
        this.invoiceRepository = invoiceRepository;
        this.weddingService = weddingService;
        this.pdfService = pdfService;
        this.converter = converter;
    }

    public void createInvoice(final CreateInvoiceRequest request) {
        Invoice invoice = Invoice.builder()
                .createdTime(DateHelper.getCurrentDateTime())
                .dueDate(request.getDueDate())
                .invoiceAmount(0.0)
                .paid(false)
                .wedding(weddingService.findWeddingById(request.getWeddingId()))
                .build();

        if (invoice.getInvoiceItems() != null) {
            invoice.setInvoiceAmount(calculateInvoiceAmount(invoice.getInvoiceItems()));
        }

        invoiceRepository.save(invoice);
        log.info(BusinessLogMessage.Invoice.INVOICE_CREATED + invoice.getId());
    }

    public ByteArrayInputStream generatePdf(final String id) {
        log.info(BusinessLogMessage.Invoice.INVOICE_PDF_GENERATED + id);
        return pdfService.generatePdf(findInvoiceById(id));
    }

    public void updateInvoice(final String id, final UpdateInvoiceRequest request) {
        Invoice invoice = findInvoiceById(id);

        if (invoice.getInvoiceItems() != null) {
            invoice.setInvoiceAmount(calculateInvoiceAmount(invoice.getInvoiceItems()));
        }

        invoice.setDueDate(request.getDueDate());

        invoiceRepository.save(invoice);
        log.info(BusinessLogMessage.Invoice.INVOICE_UPDATED + id);
    }

    public void paymentInvoice(final String id) {
        Invoice invoice = findInvoiceById(id);

        invoice.setPaid(true);
        invoice.setPaymentTime(DateHelper.getCurrentDateTime());

        invoiceRepository.save(invoice);
        log.info(BusinessLogMessage.Invoice.INVOICE_PAID + id);
    }

    public void deleteInvoice(final String id) {
        invoiceRepository.delete(findInvoiceById(id));
        log.info(BusinessLogMessage.Invoice.INVOICE_DELETED + id);
    }

    public InvoiceDto findInvoice(final String id) {
        log.info(BusinessLogMessage.Invoice.INVOICE_FOUND + id);
        return converter.convert(findInvoiceById(id));
    }

    public List<InvoiceDto> findAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();

        if (invoices.isEmpty()) {
            log.info(BusinessLogMessage.Invoice.INVOICE_LIST_EMPTY);
            throw new InEventNotFoundException(BusinessMessage.Invoice.INVOICE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Invoice.INVOICE_LISTED);
        return converter.convert(invoices);
    }

    protected Invoice findInvoiceById(final String id) {
        return invoiceRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Invoice.INVOICE_NOT_FOUND + id);
            throw new InEventNotFoundException(BusinessMessage.Invoice.INVOICE_NOT_FOUND);
        });
    }

    // Calculate the total amount of the invoice
    private Double calculateInvoiceAmount(final List<InvoiceItem> invoiceItems) {
        return invoiceItems.stream()
                .map(InvoiceItem::getPrice)
                .reduce(0.0, Double::sum);

    }
}
