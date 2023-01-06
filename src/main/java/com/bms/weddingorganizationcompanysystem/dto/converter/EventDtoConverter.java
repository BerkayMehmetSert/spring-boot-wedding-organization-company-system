package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.EventDto;
import com.bms.weddingorganizationcompanysystem.model.Event;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventDtoConverter {
    private final EventInEventDtoConverter eventInEventDtoConverter;

    public EventDtoConverter(EventInEventDtoConverter eventInEventDtoConverter) {
        this.eventInEventDtoConverter = eventInEventDtoConverter;
    }

    public EventDto convert(Event from) {
        return new EventDto(
                from.getId(),
                from.getName(),
                from.getStartTimePlanned(),
                from.getEndTimePlanned(),
                from.getStartTime(),
                from.getEndTime(),
                from.getBudgePlanned(),
                from.getLocation() != null ? from.getLocation().getId() : null,
                from.getWedding() != null ? from.getWedding().getId() : null,
                from.getInEvents() != null ? eventInEventDtoConverter.convert(from.getInEvents()) : null
        );
    }

    public List<EventDto> convert(List<Event> from) {
        return from.stream().map(this::convert).toList();
    }
}
