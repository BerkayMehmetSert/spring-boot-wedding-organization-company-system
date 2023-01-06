package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.CityLocationDto;
import com.bms.weddingorganizationcompanysystem.model.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityLocationDtoConverter {
    public CityLocationDto convert(Location from) {
        return new CityLocationDto(
                from.getId(),
                from.getName()
        );
    }

    public List<CityLocationDto> convert(List<Location> from) {
        return from.stream().map(this::convert).toList();
    }
}
