package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentProviderDto;
import com.bms.weddingorganizationcompanysystem.model.EmploymentProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmploymentProviderDtoConverter {
    public EmploymentProviderDto convert(EmploymentProvider from) {
        return new EmploymentProviderDto(
                from.getId(),
                from.getDetail(),
                from.getIsActive(),
                from.getEmployment() != null ? from.getEmployment().getId() : null,
                from.getPartner() != null ? from.getPartner().getId() : null
        );
    }

    public List<EmploymentProviderDto> convert(List<EmploymentProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
