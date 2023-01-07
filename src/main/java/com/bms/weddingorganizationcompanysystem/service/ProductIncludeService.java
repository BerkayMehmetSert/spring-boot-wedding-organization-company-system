package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.ProductIncludeDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.ProductIncludeDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.productinclude.ProductIncludeListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.productinclude.ProductIncludeNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.ProductInclude;
import com.bms.weddingorganizationcompanysystem.repository.ProductIncludeRepository;
import com.bms.weddingorganizationcompanysystem.request.productinclude.CreateProductIncludeRequest;
import com.bms.weddingorganizationcompanysystem.request.productinclude.UpdateProductIncludeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductIncludeService {
    private final ProductIncludeRepository productIncludeRepository;
    private final StatusService statusService;
    private final EventService eventService;
    private final ProductProviderService productProviderService;
    private final ProductIncludeDtoConverter converter;

    public ProductIncludeService(ProductIncludeRepository productIncludeRepository,
                                 StatusService statusService,
                                 EventService eventService,
                                 ProductProviderService productProviderService,
                                 ProductIncludeDtoConverter converter) {
        this.productIncludeRepository = productIncludeRepository;
        this.statusService = statusService;
        this.eventService = eventService;
        this.productProviderService = productProviderService;
        this.converter = converter;
    }

    public void createProductInclude(final CreateProductIncludeRequest request) {
        ProductInclude productInclude = ProductInclude.builder()
                .price(request.getPrice())
                .productProvider(productProviderService.findProductProviderById(request.getProductProviderId()))
                .event(eventService.findEventById(request.getEventId()))
                .status(statusService.findStatusById(request.getStatusId()))
                .build();

        productIncludeRepository.save(productInclude);
        log.info(BusinessLogMessage.ProductInclude.PRODUCT_INCLUDE_CREATED);
    }

    public void updateProductInclude(final String id, final UpdateProductIncludeRequest request) {
        ProductInclude productInclude = findProductIncludeById(id);

        productInclude.setPrice(request.getPrice());
        productInclude.setStatus(statusService.findStatusById(request.getStatusId()));

        productIncludeRepository.save(productInclude);
        log.info(BusinessLogMessage.ProductInclude.PRODUCT_INCLUDE_UPDATED + id);
    }

    public void deleteProductInclude(final String id) {
        productIncludeRepository.delete(findProductIncludeById(id));
        log.info(BusinessLogMessage.ProductInclude.PRODUCT_INCLUDE_DELETED + id);
    }

    public ProductIncludeDto findProductInclude(final String id) {
        log.info(BusinessLogMessage.ProductInclude.PRODUCT_INCLUDE_FOUND + id);
        return converter.convert(findProductIncludeById(id));
    }

    public List<ProductIncludeDto> findAllProductIncludes() {
        List<ProductInclude> productIncludes = productIncludeRepository.findAll();

        if (productIncludes.isEmpty()) {
            log.error(BusinessLogMessage.ProductInclude.PRODUCT_INCLUDE_LIST_EMPTY);
            throw new ProductIncludeListEmptyException(BusinessMessage.ProductInclude.PRODUCT_INCLUDE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.ProductInclude.PRODUCT_INCLUDE_LISTED);
        return converter.convert(productIncludes);
    }

    protected ProductInclude findProductIncludeById(final String id) {
        return productIncludeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.ProductInclude.PRODUCT_INCLUDE_NOT_FOUND + id);
                    throw new ProductIncludeNotFoundException(BusinessMessage.ProductInclude.PRODUCT_INCLUDE_NOT_FOUND);
                });
    }
}
