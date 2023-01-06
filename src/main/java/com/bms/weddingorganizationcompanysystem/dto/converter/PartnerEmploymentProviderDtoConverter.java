package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.PartnerEmploymentProviderDto;
import com.bms.weddingorganizationcompanysystem.model.EmploymentProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartnerEmploymentProviderDtoConverter {
    public PartnerEmploymentProviderDto convert(EmploymentProvider from) {
        return new PartnerEmploymentProviderDto(
                from.getId(),
                from.getDetail(),
                from.getIsActive(),
                from.getEmployment() != null ? from.getEmployment().getId() : null
        );
    }

    public List<PartnerEmploymentProviderDto> convert(List<EmploymentProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
