package com.bms.weddingorganizationcompanysystem.repository;

import com.bms.weddingorganizationcompanysystem.model.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentRepository extends JpaRepository<Employment, String> {
    boolean existsByServiceNameIgnoreCase(String serviceName);
}