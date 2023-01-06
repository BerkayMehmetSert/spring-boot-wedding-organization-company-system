package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.StatusDto;
import com.bms.weddingorganizationcompanysystem.model.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusDtoConverter {
    public StatusDto convert(Status from) {
        return new StatusDto(
                from.getId(),
                from.getName(),
                from.getOffer(),
                from.getOfferAccepted(),
                from.getOfferRejected()
        );
    }

    public List<StatusDto> convert(List<Status> from) {
        return from.stream().map(this::convert).toList();
    }
}
