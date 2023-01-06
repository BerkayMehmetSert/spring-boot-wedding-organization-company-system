package com.bms.weddingorganizationcompanysystem.repository;

import com.bms.weddingorganizationcompanysystem.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, String> {
}