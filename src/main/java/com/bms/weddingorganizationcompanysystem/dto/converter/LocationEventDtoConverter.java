package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.LocationEventDto;
import com.bms.weddingorganizationcompanysystem.model.Event;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationEventDtoConverter {
    public LocationEventDto convert(Event from) {
        return new LocationEventDto(
                from.getId(),
                from.getName(),
                from.getStartTimePlanned(),
                from.getEndTimePlanned(),
                from.getStartTime(),
                from.getEndTime(),
                from.getBudgePlanned(),
                from.getWedding() != null ? from.getWedding().getId() : null
        );
    }

    public List<LocationEventDto> convert(List<Event> from) {
        return from.stream().map(this::convert).toList();
    }
}
