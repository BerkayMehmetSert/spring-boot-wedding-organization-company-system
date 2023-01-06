package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.CountryDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.CreateCountryRequest;
import com.bms.weddingorganizationcompanysystem.request.UpdateCountryRequest;
import com.bms.weddingorganizationcompanysystem.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
@Slf4j
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<Void> createCountry(@RequestBody CreateCountryRequest request) {
        countryService.createCountry(request);

        log.info(ControllerLogMessage.Country.COUNTRY_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCountry(@PathVariable String id,
                                              @RequestBody UpdateCountryRequest request) {
        countryService.updateCountry(id, request);

        log.info(ControllerLogMessage.Country.COUNTRY_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String id) {
        countryService.deleteCountry(id);

        log.info(ControllerLogMessage.Country.COUNTRY_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDto> findCountry(@PathVariable String id) {
        CountryDto countryDto = countryService.findCountry(id);

        log.info(ControllerLogMessage.Country.COUNTRY_FOUND + id);
        return ResponseEntity.ok(countryDto);
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> findAllCountry() {
        List<CountryDto> countryDtoList = countryService.findAllCountry();

        log.info(ControllerLogMessage.Country.COUNTRY_LISTED);
        return ResponseEntity.ok(countryDtoList);
    }
}
