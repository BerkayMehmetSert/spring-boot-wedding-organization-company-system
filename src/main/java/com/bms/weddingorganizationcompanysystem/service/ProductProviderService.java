package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.ProductProviderDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.ProductProviderDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.productprovider.ProductProviderListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.productprovider.ProductProviderNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.ProductProvider;
import com.bms.weddingorganizationcompanysystem.repository.ProductProviderRepository;
import com.bms.weddingorganizationcompanysystem.request.productprovider.CreateProductProviderRequest;
import com.bms.weddingorganizationcompanysystem.request.productprovider.UpdateProductProviderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductProviderService {
    private final ProductProviderRepository productProviderRepository;
    private final ProductService productService;
    private final PartnerService partnerService;
    private final ProductProviderDtoConverter converter;

    public ProductProviderService(ProductProviderRepository productProviderRepository,
                                  ProductService productService,
                                  PartnerService partnerService,
                                  ProductProviderDtoConverter converter) {
        this.productProviderRepository = productProviderRepository;
        this.productService = productService;
        this.partnerService = partnerService;
        this.converter = converter;
    }

    public void createProductProvider(final CreateProductProviderRequest request) {
        ProductProvider productProvider = ProductProvider.builder()
                .detail(request.getDetail())
                .isActive(true)
                .product(productService.findProductById(request.getProductId()))
                .partner(partnerService.findPartnerById(request.getPartnerId()))
                .build();

        productProviderRepository.save(productProvider);
        log.info(BusinessLogMessage.ProductProvider.PRODUCT_PROVIDER_CREATED + productProvider.getId());
    }

    public void updateProductProvider(final String id, final UpdateProductProviderRequest request) {
        ProductProvider productProvider = findProductProviderById(id);

        productProvider.setDetail(request.getDetail());
        productProvider.setProduct(productService.findProductById(request.getProductId()));
        productProvider.setPartner(partnerService.findPartnerById(request.getPartnerId()));

        productProviderRepository.save(productProvider);
        log.info(BusinessLogMessage.ProductProvider.PRODUCT_PROVIDER_UPDATED + id);
    }

    public void deleteProductProvider(final String id) {
        ProductProvider productProvider = findProductProviderById(id);

        productProvider.setIsActive(false);

        productProviderRepository.save(productProvider);
        log.info(BusinessLogMessage.ProductProvider.PRODUCT_PROVIDER_DELETED + id);
    }

    public ProductProviderDto findProductProvider(final String id) {
        log.info(BusinessLogMessage.ProductProvider.PRODUCT_PROVIDER_FOUND + id);
        return converter.convert(findProductProviderById(id));
    }

    public List<ProductProviderDto> findAllProductProviders() {
        List<ProductProvider> productProviders = productProviderRepository.findAll().stream()
                .filter(x -> x.getIsActive().equals(true))
                .toList();

        if (productProviders.isEmpty()) {
            log.error(BusinessLogMessage.ProductProvider.PRODUCT_PROVIDER_LIST_EMPTY);
            throw new ProductProviderListEmptyException(BusinessMessage.ProductProvider.PRODUCT_PROVIDER_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.ProductProvider.PRODUCT_PROVIDER_LISTED);
        return converter.convert(productProviders);
    }

    protected ProductProvider findProductProviderById(final String id) {
        return productProviderRepository.findById(id)
                .filter(x -> x.getIsActive().equals(true))
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.ProductProvider.PRODUCT_PROVIDER_NOT_FOUND + id);
                    throw new ProductProviderNotFoundException(BusinessMessage
                            .ProductProvider.PRODUCT_PROVIDER_NOT_FOUND);
                });
    }
}
