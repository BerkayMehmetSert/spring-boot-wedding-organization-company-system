package com.bms.weddingorganizationcompanysystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wedding {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 16, nullable = false)
    private String weddingCode;

    private LocalDateTime startTimePlanned;

    private LocalDateTime endTimePlanned;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Column(nullable = false)
    private Boolean budgePlanned;

    @OneToMany(mappedBy = "wedding")
    private List<Participate> participates;

    @OneToMany(mappedBy = "wedding")
    private List<Invoice> invoices;

}
