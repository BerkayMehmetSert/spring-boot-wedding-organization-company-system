package com.bms.weddingorganizationcompanysystem.dto;

import java.util.List;

public record CountryDto(
    String id,
    String name,
    List<CountryCityDto> cities
) {
}
