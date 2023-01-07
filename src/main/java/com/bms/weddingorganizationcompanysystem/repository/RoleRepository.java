package com.bms.weddingorganizationcompanysystem.repository;

import com.bms.weddingorganizationcompanysystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    boolean existsByNameIgnoreCase(String name);
}