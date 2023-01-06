package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.CountryCityDto;
import com.bms.weddingorganizationcompanysystem.model.City;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryCityDtoConverter {
    public CountryCityDto convert(City from) {
        return new CountryCityDto(
                from.getId(),
                from.getName(),
                from.getPostalCode()
        );
    }

    public List<CountryCityDto> convert(List<City> from) {
        return from.stream().map(this::convert).toList();
    }
}
