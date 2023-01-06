package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.RoleDto;
import com.bms.weddingorganizationcompanysystem.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleDtoConverter {
    public RoleDto convert(Role from) {
        return new RoleDto(
                from.getId(),
                from.getName()
        );
    }

    public List<RoleDto> convert(List<Role> from) {
        return from.stream().map(this::convert).toList();
    }
}

