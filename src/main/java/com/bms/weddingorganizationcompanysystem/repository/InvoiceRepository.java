package com.bms.weddingorganizationcompanysystem.repository;

import com.bms.weddingorganizationcompanysystem.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
}