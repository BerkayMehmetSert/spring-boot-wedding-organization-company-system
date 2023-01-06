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
public class Partner {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 16, nullable = false)
    private String partnerCode;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "partner")
    private List<EmploymentProvider> employmentProviders;

    @OneToMany(mappedBy = "partner")
    private List<ProductProvider> productProviders;
}
