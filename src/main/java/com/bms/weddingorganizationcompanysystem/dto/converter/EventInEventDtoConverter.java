package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.EventInEventDto;
import com.bms.weddingorganizationcompanysystem.model.InEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventInEventDtoConverter {
    public EventInEventDto convert(InEvent from) {
        return new EventInEventDto(
                from.getId(),
                from.getDetail(),
                from.getParticipate() != null ? from.getParticipate().getId() : null
        );
    }

    public List<EventInEventDto> convert(List<InEvent> from) {
        return from.stream().map(this::convert).toList();
    }
}
