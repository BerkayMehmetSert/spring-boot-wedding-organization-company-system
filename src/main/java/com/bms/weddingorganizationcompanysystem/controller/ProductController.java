package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.ProductDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.product.CreateProductRequest;
import com.bms.weddingorganizationcompanysystem.request.product.UpdateProductRequest;
import com.bms.weddingorganizationcompanysystem.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody CreateProductRequest request) {
        productService.createProduct(request);

        log.info(ControllerLogMessage.Product.PRODUCT_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable String id,
                                              @RequestBody UpdateProductRequest request) {
        productService.updateProduct(id, request);

        log.info(ControllerLogMessage.Product.PRODUCT_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);

        log.info(ControllerLogMessage.Product.PRODUCT_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProduct(@PathVariable String id) {
        ProductDto products = productService.findProduct(id);

        log.info(ControllerLogMessage.Product.PRODUCT_FOUND + id);
        return ResponseEntity.ok(products);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        List<ProductDto> products = productService.findAllProducts();

        log.info(ControllerLogMessage.Product.PRODUCT_LISTED);
        return ResponseEntity.ok(products);
    }
}
