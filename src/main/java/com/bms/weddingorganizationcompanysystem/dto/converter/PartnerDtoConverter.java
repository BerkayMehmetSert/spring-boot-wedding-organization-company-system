package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.PartnerDto;
import com.bms.weddingorganizationcompanysystem.model.Partner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartnerDtoConverter {
    private final PartnerEmploymentProviderDtoConverter partnerEmploymentProviderDtoConverter;
    private final PartnerProductProviderDtoConverter partnerProductProviderDtoConverter;

    public PartnerDtoConverter(PartnerEmploymentProviderDtoConverter partnerEmploymentProviderDtoConverter,
                               PartnerProductProviderDtoConverter partnerProductProviderDtoConverter) {
        this.partnerEmploymentProviderDtoConverter = partnerEmploymentProviderDtoConverter;
        this.partnerProductProviderDtoConverter = partnerProductProviderDtoConverter;
    }

    public PartnerDto convert(Partner from) {
        return new PartnerDto(
                from.getId(),
                from.getPartnerCode(),
                from.getName(),
                from.getEmploymentProviders() != null ? partnerEmploymentProviderDtoConverter.convert(from.getEmploymentProviders()) : null,
                from.getProductProviders() != null ? partnerProductProviderDtoConverter.convert(from.getProductProviders()) : null
        );
    }

    public List<PartnerDto> convert(List<Partner> from) {
        return from.stream().map(this::convert).toList();
    }
}
