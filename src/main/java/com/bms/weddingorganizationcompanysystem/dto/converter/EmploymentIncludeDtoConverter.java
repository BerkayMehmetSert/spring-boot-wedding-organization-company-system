package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentIncludeDto;
import com.bms.weddingorganizationcompanysystem.model.EmploymentInclude;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmploymentIncludeDtoConverter {
    public EmploymentIncludeDto convert(EmploymentInclude from) {
        return new EmploymentIncludeDto(
                from.getId(),
                from.getPrice(),
                from.getStatus() != null ? from.getStatus().getId() : null,
                from.getEvent() != null ? from.getEvent().getId() : null,
                from.getEmploymentProvider() != null ? from.getEmploymentProvider().getId() : null
        );
    }

    public List<EmploymentIncludeDto> convert(List<EmploymentInclude> from) {
        return from.stream().map(this::convert).toList();
    }
}
