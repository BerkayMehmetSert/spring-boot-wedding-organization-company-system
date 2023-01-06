package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentEmploymentProviderDto;
import com.bms.weddingorganizationcompanysystem.model.EmploymentProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmploymentEmploymentProviderDtoConverter {
    public EmploymentEmploymentProviderDto convert(EmploymentProvider from) {
        return new EmploymentEmploymentProviderDto(
                from.getId(),
                from.getDetail(),
                from.getIsActive(),
                from.getPartner() != null ? from.getPartner().getId() : null
        );
    }

    public List<EmploymentEmploymentProviderDto> convert(List<EmploymentProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
