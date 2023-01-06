package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.LocationDto;
import com.bms.weddingorganizationcompanysystem.model.Location;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationDtoConverter {
    private final LocationEventDtoConverter locationEventDtoConverter;

    public LocationDtoConverter(LocationEventDtoConverter locationEventDtoConverter) {
        this.locationEventDtoConverter = locationEventDtoConverter;
    }

    public LocationDto convert(Location from) {
        return new LocationDto(
                from.getId(),
                from.getName(),
                from.getCity() != null ? from.getCity().getId() : null,
                from.getEvents() != null ? locationEventDtoConverter.convert(from.getEvents()) : null
        );
    }

    public List<LocationDto> convert(List<Location> from) {
        return from.stream().map(this::convert).toList();
    }
}
