package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.ProductProviderDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.productprovider.CreateProductProviderRequest;
import com.bms.weddingorganizationcompanysystem.request.productprovider.UpdateProductProviderRequest;
import com.bms.weddingorganizationcompanysystem.service.ProductProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-provider")
@Slf4j
public class ProductProviderController {
    private final ProductProviderService productProviderService;

    public ProductProviderController(ProductProviderService productProviderService) {
        this.productProviderService = productProviderService;
    }

    @PostMapping
    public ResponseEntity<Void> createProductProvider(@RequestBody CreateProductProviderRequest request) {
        productProviderService.createProductProvider(request);

        log.info(ControllerLogMessage.ProductProvider.PRODUCT_PROVIDER_CREATED + request.getProductId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductProvider(@PathVariable String id,
                                                      @RequestBody UpdateProductProviderRequest request) {
        productProviderService.updateProductProvider(id, request);

        log.info(ControllerLogMessage.ProductProvider.PRODUCT_PROVIDER_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductProvider(@PathVariable String id) {
        productProviderService.deleteProductProvider(id);

        log.info(ControllerLogMessage.ProductProvider.PRODUCT_PROVIDER_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductProviderDto> findProductProvider(@PathVariable String id) {
        ProductProviderDto productProvider = productProviderService.findProductProvider(id);

        log.info(ControllerLogMessage.ProductProvider.PRODUCT_PROVIDER_FOUND + id);
        return ResponseEntity.ok(productProvider);
    }

    @GetMapping
    public ResponseEntity<List<ProductProviderDto>> findAllProductProviders() {
        List<ProductProviderDto> productProviders = productProviderService.findAllProductProviders();

        log.info(ControllerLogMessage.ProductProvider.PRODUCT_PROVIDER_LISTED);
        return ResponseEntity.ok(productProviders);
    }
}
