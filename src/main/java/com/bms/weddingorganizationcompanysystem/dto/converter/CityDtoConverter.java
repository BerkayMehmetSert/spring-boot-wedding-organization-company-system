package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.CityDto;
import com.bms.weddingorganizationcompanysystem.model.City;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityDtoConverter {
    private final CityLocationDtoConverter cityLocationDtoConverter;

    public CityDtoConverter(CityLocationDtoConverter cityLocationDtoConverter) {
        this.cityLocationDtoConverter = cityLocationDtoConverter;
    }

    public CityDto convert(City from) {
        return new CityDto(
                from.getId(),
                from.getName(),
                from.getPostalCode(),
                from.getCountry() != null ? from.getCountry().getId() : null,
                from.getLocations() != null ? cityLocationDtoConverter.convert(from.getLocations()) : null
        );
    }

    public List<CityDto> convert(List<City> from) {
        return from.stream().map(this::convert).toList();
    }
}
