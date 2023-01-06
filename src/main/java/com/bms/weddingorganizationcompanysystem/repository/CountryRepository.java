package com.bms.weddingorganizationcompanysystem.repository;

import com.bms.weddingorganizationcompanysystem.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}