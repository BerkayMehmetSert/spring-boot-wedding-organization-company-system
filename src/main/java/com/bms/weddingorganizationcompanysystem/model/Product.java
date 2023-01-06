package com.bms.weddingorganizationcompanysystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 16, nullable = false)
    private String productCode;

    @Column(nullable = false)
    private String name;

    private String description;

    private String picture;

    @Column(nullable = false)
    private Double price;

    @OneToMany(mappedBy = "product")
    private List<ProductProvider> productProviders;
}
