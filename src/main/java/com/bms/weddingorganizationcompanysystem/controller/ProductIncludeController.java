package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.ProductIncludeDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.productinclude.CreateProductIncludeRequest;
import com.bms.weddingorganizationcompanysystem.request.productinclude.UpdateProductIncludeRequest;
import com.bms.weddingorganizationcompanysystem.service.ProductIncludeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-include")
@Slf4j
public class ProductIncludeController {
    private final ProductIncludeService productIncludeService;

    public ProductIncludeController(ProductIncludeService productIncludeService) {
        this.productIncludeService = productIncludeService;
    }

    @PostMapping
    public ResponseEntity<Void> createProductInclude(@RequestBody CreateProductIncludeRequest request) {
        productIncludeService.createProductInclude(request);

        log.info(ControllerLogMessage.ProductInclude.PRODUCT_INCLUDE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProductInclude(@PathVariable String id,
                                                     @RequestBody UpdateProductIncludeRequest request) {
        productIncludeService.updateProductInclude(id, request);

        log.info(ControllerLogMessage.ProductInclude.PRODUCT_INCLUDE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductInclude(@PathVariable String id) {
        productIncludeService.deleteProductInclude(id);

        log.info(ControllerLogMessage.ProductInclude.PRODUCT_INCLUDE_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductIncludeDto> findProductInclude(@PathVariable String id) {
        ProductIncludeDto productInclude = productIncludeService.findProductInclude(id);

        log.info(ControllerLogMessage.ProductInclude.PRODUCT_INCLUDE_FOUND + id);
        return ResponseEntity.ok(productInclude);
    }

    @GetMapping
    public ResponseEntity<List<ProductIncludeDto>> findAllProductInclude() {
        List<ProductIncludeDto> productIncludes = productIncludeService.findAllProductIncludes();

        log.info(ControllerLogMessage.ProductInclude.PRODUCT_INCLUDE_LISTED);
        return ResponseEntity.ok(productIncludes);
    }
}
