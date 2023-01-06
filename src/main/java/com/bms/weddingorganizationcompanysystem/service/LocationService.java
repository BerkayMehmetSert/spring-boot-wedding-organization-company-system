package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.LocationDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.LocationDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.location.LocationNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Location;
import com.bms.weddingorganizationcompanysystem.repository.LocationRepository;
import com.bms.weddingorganizationcompanysystem.request.location.CreateLocationRequest;
import com.bms.weddingorganizationcompanysystem.request.location.UpdateLocationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LocationService {
    private final LocationRepository locationRepository;
    private final CityService cityService;
    private final LocationDtoConverter converter;

    public LocationService(LocationRepository locationRepository,
                           CityService cityService,
                           LocationDtoConverter converter) {
        this.locationRepository = locationRepository;
        this.cityService = cityService;
        this.converter = converter;
    }

    public void createLocation(final CreateLocationRequest request) {
        Location location = Location.builder()
                .name(request.getName())
                .city(cityService.findCityById(request.getCityId()))
                .build();

        log.info(BusinessLogMessage.Location.LOCATION_CREATED + request.getName());
        locationRepository.save(location);
    }

    public void updateLocation(final String id, final UpdateLocationRequest request) {
        Location location = findLocationById(id);

        location.setName(request.getName());
        location.setCity(cityService.findCityById(request.getCityId()));
        locationRepository.save(location);
        log.info(BusinessLogMessage.Location.LOCATION_UPDATED + id);
    }

    public void deleteLocation(final String id) {
        locationRepository.delete(findLocationById(id));
        log.info(BusinessLogMessage.Location.LOCATION_DELETED + id);
    }

    public LocationDto findLocation(final String id) {
        log.info(BusinessLogMessage.Location.LOCATION_FOUND + id);
        return converter.convert(findLocationById(id));
    }

    public List<LocationDto> findAllLocations() {
        List<Location> locations = locationRepository.findAll();

        if (locations.isEmpty()) {
            log.error(BusinessLogMessage.Location.LOCATION_LIST_EMPTY);
            throw new LocationNotFoundException(BusinessMessage.Location.LOCATION_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Location.LOCATION_LISTED);
        return converter.convert(locations);
    }

    protected Location findLocationById(final String id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Location.LOCATION_NOT_FOUND + id);
                    throw new LocationNotFoundException(BusinessMessage.Location.LOCATION_NOT_FOUND);
                });
    }
}
