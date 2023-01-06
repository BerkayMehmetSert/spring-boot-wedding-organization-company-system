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
public class Status {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean offer;

    @Column(nullable = false)
    private Boolean offerAccepted;

    @Column(nullable = false)
    private Boolean offerRejected;

    @OneToMany(mappedBy = "status")
    private List<ProductInclude> productIncludes;

    @OneToMany(mappedBy = "status")
    private List<EmploymentInclude> employmentIncludes;
}
