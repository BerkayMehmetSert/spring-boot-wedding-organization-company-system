package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.InEventDto;
import com.bms.weddingorganizationcompanysystem.model.InEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InEventDtoConverter {
    public InEventDto convert(InEvent from) {
        return new InEventDto(
                from.getId(),
                from.getDetail(),
                from.getEvent() != null ? from.getEvent().getId() : null,
                from.getParticipate() != null ? from.getParticipate().getId() : null
        );
    }

    public List<InEventDto> convert(List<InEvent> from) {
        return from.stream().map(this::convert).toList();
    }
}
