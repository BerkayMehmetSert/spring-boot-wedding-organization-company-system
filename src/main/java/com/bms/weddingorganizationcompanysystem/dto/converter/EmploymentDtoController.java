package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentDto;
import com.bms.weddingorganizationcompanysystem.model.Employment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmploymentDtoController {
    private final EmploymentEmploymentProviderDtoConverter converter;

    public EmploymentDtoController(EmploymentEmploymentProviderDtoConverter converter) {
        this.converter = converter;
    }

    public EmploymentDto convert(Employment from) {
        return new EmploymentDto(
                from.getId(),
                from.getServiceCode(),
                from.getServiceName(),
                from.getDescription(),
                from.getPicture(),
                from.getEmploymentProviders() != null ? converter.convert(from.getEmploymentProviders()) : null
        );
    }

    public List<EmploymentDto> convert(List<Employment> from) {
        return from.stream().map(this::convert).toList();
    }
}
