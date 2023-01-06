package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.WeddingParticipateDto;
import com.bms.weddingorganizationcompanysystem.model.Participate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeddingParticipateDtoConverter {
    public WeddingParticipateDto convert(Participate from) {
        return new WeddingParticipateDto(
                from.getId(),
                from.getPerson() != null ? from.getPerson().getId() : null,
                from.getRole() != null ? from.getRole().getId() : null
        );
    }

    public List<WeddingParticipateDto> convert(List<Participate> from) {
        return from.stream().map(this::convert).toList();
    }
}
