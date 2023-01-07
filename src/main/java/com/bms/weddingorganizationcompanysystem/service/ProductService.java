package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.ProductDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.ProductDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.product.ProductAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.product.ProductListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.product.ProductNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.Generator;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Product;
import com.bms.weddingorganizationcompanysystem.repository.ProductRepository;
import com.bms.weddingorganizationcompanysystem.request.product.CreateProductRequest;
import com.bms.weddingorganizationcompanysystem.request.product.UpdateProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDtoConverter converter;

    public ProductService(ProductRepository productRepository,
                          ProductDtoConverter converter) {
        this.productRepository = productRepository;
        this.converter = converter;
    }

    public void createProduct(final CreateProductRequest request) {
        checkIfProductExists(request.getName());

        Product product = Product.builder()
                .productCode(Generator.generateCode())
                .name(request.getName())
                .description(request.getDescription())
                .picture(request.getPicture())
                .price(request.getPrice())
                .build();

        productRepository.save(product);
        log.info(BusinessLogMessage.Product.PRODUCT_CREATED + request.getName());
    }

    public void updateProduct(final String id, final UpdateProductRequest request) {
        Product product = findProductById(id);

        if (!product.getName().equals(request.getName())) {
            checkIfProductExists(request.getName());
        }

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPicture(request.getPicture());
        product.setPrice(request.getPrice());

        productRepository.save(product);
        log.info(BusinessLogMessage.Product.PRODUCT_UPDATED + request.getName());
    }

    public void deleteProduct(final String id) {
        productRepository.delete(findProductById(id));
        log.info(BusinessLogMessage.Product.PRODUCT_DELETED + id);
    }

    public ProductDto findProduct(final String id) {
        log.info(BusinessLogMessage.Product.PRODUCT_FOUND + id);
        return converter.convert(findProductById(id));
    }

    public List<ProductDto> findAllProducts() {
        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            log.error(BusinessLogMessage.Product.PRODUCT_LIST_EMPTY);
            throw new ProductListEmptyException(BusinessMessage.Product.PRODUCT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Product.PRODUCT_LISTED);
        return converter.convert(products);
    }

    protected Product findProductById(final String id) {
        return productRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Product.PRODUCT_NOT_FOUND + id);
            throw new ProductNotFoundException(BusinessMessage.Product.PRODUCT_NOT_FOUND);
        });
    }

    private void checkIfProductExists(final String name) {
        if (productRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.Product.PRODUCT_ALREADY_EXISTS + name);
            throw new ProductAlreadyExistException(BusinessMessage.Product.PRODUCT_ALREADY_EXISTS);
        }
    }
}
