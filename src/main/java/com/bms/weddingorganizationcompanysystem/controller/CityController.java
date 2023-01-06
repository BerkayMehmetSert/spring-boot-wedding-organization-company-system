package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.CityDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.city.CreateCityRequest;
import com.bms.weddingorganizationcompanysystem.request.city.UpdateCityRequest;
import com.bms.weddingorganizationcompanysystem.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
@Slf4j
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<Void> createCity(@RequestBody CreateCityRequest request) {
        cityService.createCity(request);

        log.info(ControllerLogMessage.City.CITY_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCity(@PathVariable String id,
                                           @RequestBody UpdateCityRequest request) {
        cityService.updateCity(id, request);

        log.info(ControllerLogMessage.City.CITY_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        cityService.deleteCity(id);

        log.info(ControllerLogMessage.City.CITY_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> findCity(@PathVariable String id) {
        CityDto city = cityService.findCity(id);

        log.info(ControllerLogMessage.City.CITY_FOUND + id);
        return ResponseEntity.ok(city);
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> findAllCities() {
        List<CityDto> cities = cityService.findAllCities();

        log.info(ControllerLogMessage.City.CITY_LISTED);
        return ResponseEntity.ok(cities);
    }
}
