package com.bms.weddingorganizationcompanysystem.dto;

import java.util.List;

public record CityDto(
    String id,
    String name,
    String postalCode,
    String countryId,
    List<CityLocationDto> locations
) {
}
