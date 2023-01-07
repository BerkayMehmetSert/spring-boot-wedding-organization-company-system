package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.InvoiceItemDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.InvoiceItemDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.invoiceitem.InvoiceItemListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.invoiceitem.InvoiceItemNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.InvoiceItem;
import com.bms.weddingorganizationcompanysystem.repository.InvoiceItemRepository;
import com.bms.weddingorganizationcompanysystem.request.invoiceitem.CreateInvoiceItemRequest;
import com.bms.weddingorganizationcompanysystem.request.invoiceitem.UpdateInvoiceItemRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InvoiceItemService {
    private final InvoiceItemRepository invoiceItemRepository;
    private final InvoiceService invoiceService;
    private final EmploymentIncludeService employmentIncludeService;
    private final ProductIncludeService productIncludeService;
    private final InvoiceItemDtoConverter converter;


    public InvoiceItemService(InvoiceItemRepository invoiceItemRepository,
                              InvoiceService invoiceService,
                              EmploymentIncludeService employmentIncludeService,
                              ProductIncludeService productIncludeService,
                              InvoiceItemDtoConverter converter) {
        this.invoiceItemRepository = invoiceItemRepository;
        this.invoiceService = invoiceService;
        this.employmentIncludeService = employmentIncludeService;
        this.productIncludeService = productIncludeService;
        this.converter = converter;
    }

    public void createInvoiceItem(final CreateInvoiceItemRequest request) {
        InvoiceItem invoiceItem = InvoiceItem.builder()
                .name(request.getName())
                .price(0.0)
                .invoice(invoiceService.findInvoiceById(request.getInvoiceId()))
                .employmentInclude(employmentIncludeService.findEmploymentIncludeById(request.getEmploymentIncludeId()))
                .productInclude(productIncludeService.findProductIncludeById(request.getProductIncludeId()))
                .build();

        if (invoiceItem.getProductInclude() != null) {
            invoiceItem.setPrice(calculatePrice(invoiceItem.getProductInclude().getPrice(),
                    invoiceItem.getEmploymentInclude().getPrice()));
        }

        invoiceItemRepository.save(invoiceItem);
        log.info(BusinessLogMessage.InvoiceItem.INVOICE_ITEM_CREATED + request.getName());
    }

    public void updateInvoiceItem(final String id, final UpdateInvoiceItemRequest request) {
        InvoiceItem invoiceItem = findInvoiceItemById(id);

        invoiceItem.setName(request.getName());
        invoiceItem.setInvoice(invoiceService.findInvoiceById(request.getInvoiceId()));
        invoiceItem.setEmploymentInclude(employmentIncludeService.findEmploymentIncludeById(request.getEmploymentIncludeId()));
        invoiceItem.setProductInclude(productIncludeService.findProductIncludeById(request.getProductIncludeId()));
        invoiceItem.setPrice(calculatePrice(invoiceItem.getProductInclude().getPrice(),
                invoiceItem.getEmploymentInclude().getPrice()));

        invoiceItemRepository.save(invoiceItem);
        log.info(BusinessLogMessage.InvoiceItem.INVOICE_ITEM_UPDATED + id);
    }

    public void deleteInvoiceItem(final String id) {
        invoiceItemRepository.delete(findInvoiceItemById(id));
        log.info(BusinessLogMessage.InvoiceItem.INVOICE_ITEM_DELETED + id);
    }

    public InvoiceItemDto findInvoiceItem(final String id) {
        log.info(BusinessLogMessage.InvoiceItem.INVOICE_ITEM_FOUND + id);
        return converter.convert(findInvoiceItemById(id));
    }

    public List<InvoiceItemDto> findAllInvoiceItems() {
        List<InvoiceItem> invoiceItems = invoiceItemRepository.findAll();

        if (invoiceItems.isEmpty()) {
            log.error(BusinessLogMessage.InvoiceItem.INVOICE_ITEM_LIST_EMPTY);
            throw new InvoiceItemListEmptyException(BusinessMessage.InvoiceItem.INVOICE_ITEM_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.InvoiceItem.INVOICE_ITEM_LISTED);
        return converter.convert(invoiceItems);
    }

    protected InvoiceItem findInvoiceItemById(final String id) {
        return invoiceItemRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.InvoiceItem.INVOICE_ITEM_NOT_FOUND + id);
                    throw new InvoiceItemNotFoundException(BusinessMessage.InvoiceItem.INVOICE_ITEM_NOT_FOUND);
                });
    }

    private Double calculatePrice(final Double productPrice, final Double employmentPrice) {
        final double tax = 0.18;
        return (productPrice + employmentPrice) + ((productPrice + employmentPrice) * tax);
    }
}
