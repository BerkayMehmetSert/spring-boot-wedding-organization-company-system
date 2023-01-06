package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.ParticipateDto;
import com.bms.weddingorganizationcompanysystem.model.Participate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParticipateDtoConverter {
    public ParticipateDto convert(Participate from) {
        return new ParticipateDto(
                from.getId(),
                from.getWedding() != null ? from.getWedding().getId() : null,
                from.getPerson() != null ? from.getPerson().getId() : null,
                from.getRole() != null ? from.getRole().getId() : null
        );
    }

    public List<ParticipateDto> convert(List<Participate> from) {
        return from.stream().map(this::convert).toList();
    }
}
