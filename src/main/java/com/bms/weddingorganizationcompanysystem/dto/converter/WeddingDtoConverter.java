package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.WeddingDto;
import com.bms.weddingorganizationcompanysystem.model.Wedding;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeddingDtoConverter {
    private final WeddingParticipateDtoConverter weddingParticipateDtoConverter;
    private final WeddingInvoiceDtoConverter weddingInvoiceDtoConverter;

    public WeddingDtoConverter(WeddingParticipateDtoConverter weddingParticipateDtoConverter,
                               WeddingInvoiceDtoConverter weddingInvoiceDtoConverter) {
        this.weddingParticipateDtoConverter = weddingParticipateDtoConverter;
        this.weddingInvoiceDtoConverter = weddingInvoiceDtoConverter;
    }

    public WeddingDto convert(Wedding from) {
        return new WeddingDto(
                from.getId(),
                from.getWeddingCode(),
                from.getStartTimePlanned(),
                from.getEndTimePlanned(),
                from.getStartTime(),
                from.getEndTime(),
                from.getBudgePlanned(),
                from.getParticipates() != null ? weddingParticipateDtoConverter.convert(from.getParticipates()) : null,
                from.getInvoices() != null ? weddingInvoiceDtoConverter.convert(from.getInvoices()) : null
        );
    }

    public List<WeddingDto> convert(List<Wedding> from) {
        return from.stream().map(this::convert).toList();
    }
}
