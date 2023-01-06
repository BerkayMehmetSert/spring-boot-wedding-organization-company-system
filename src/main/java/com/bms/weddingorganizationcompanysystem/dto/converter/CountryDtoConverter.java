package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.CountryDto;
import com.bms.weddingorganizationcompanysystem.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryDtoConverter {
    private final CountryCityDtoConverter countryCityDtoConverter;

    public CountryDtoConverter(CountryCityDtoConverter countryCityDtoConverter) {
        this.countryCityDtoConverter = countryCityDtoConverter;
    }

    public CountryDto convert(Country from) {
        return new CountryDto(
                from.getId(),
                from.getName(),
                from.getCities() != null ? countryCityDtoConverter.convert(from.getCities()) : null
        );
    }

    public List<CountryDto> convert(List<Country> from) {
        return from.stream().map(this::convert).toList();
    }
}
