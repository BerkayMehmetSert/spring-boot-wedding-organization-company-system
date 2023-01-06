package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.LocationDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.location.CreateLocationRequest;
import com.bms.weddingorganizationcompanysystem.request.location.UpdateLocationRequest;
import com.bms.weddingorganizationcompanysystem.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@Slf4j
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Void> createLocation(@RequestBody CreateLocationRequest request) {
        locationService.createLocation(request);

        log.info(ControllerLogMessage.Location.LOCATION_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLocation(@PathVariable String id,
                                               @RequestBody UpdateLocationRequest request) {
        locationService.updateLocation(id, request);

        log.info(ControllerLogMessage.Location.LOCATION_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable String id) {
        locationService.deleteLocation(id);

        log.info(ControllerLogMessage.Location.LOCATION_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> findLocation(@PathVariable String id) {
        LocationDto location = locationService.findLocation(id);

        log.info(ControllerLogMessage.Location.LOCATION_FOUND + id);
        return ResponseEntity.ok(location);
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> findAllLocations() {
        List<LocationDto> locations = locationService.findAllLocations();

        log.info(ControllerLogMessage.Location.LOCATION_LISTED);
        return ResponseEntity.ok(locations);
    }
}
