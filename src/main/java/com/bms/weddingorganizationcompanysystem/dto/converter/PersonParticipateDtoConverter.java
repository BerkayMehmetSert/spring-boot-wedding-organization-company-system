package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.PersonParticipateDto;
import com.bms.weddingorganizationcompanysystem.model.Participate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonParticipateDtoConverter {
    public PersonParticipateDto convert(Participate from) {
        return new PersonParticipateDto(
                from.getId(),
                from.getWedding() != null ? from.getWedding().getId() : null,
                from.getRole() != null ? from.getRole().getId() : null
        );
    }

    public List<PersonParticipateDto> convert(List<Participate> from) {
        return from.stream().map(this::convert).toList();
    }
}
