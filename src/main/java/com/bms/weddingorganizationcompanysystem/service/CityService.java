package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.CityDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.CityDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.city.CityAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.city.CityListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.city.CityNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.City;
import com.bms.weddingorganizationcompanysystem.repository.CityRepository;
import com.bms.weddingorganizationcompanysystem.request.city.CreateCityRequest;
import com.bms.weddingorganizationcompanysystem.request.city.UpdateCityRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CityService {
    private final CityRepository cityRepository;
    private final CountryService countryService;
    private final CityDtoConverter converter;

    public CityService(CityRepository cityRepository,
                       CountryService countryService,
                       CityDtoConverter converter) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
        this.converter = converter;
    }

    public void createCity(final CreateCityRequest request) {
        checkIfCityExists(request.getName());

        City city = City.builder()
                .name(request.getName())
                .postalCode(request.getPostalCode())
                .country(countryService.findCountryById(request.getCountryId()))
                .build();

        cityRepository.save(city);
        log.info(BusinessLogMessage.City.CITY_CREATED + city.getName());
    }

    public void updateCity(final String id, final UpdateCityRequest request) {
        City city = findCityById(id);

        if (!city.getName().equals(request.getName())) {
            checkIfCityExists(request.getName());
        }

        city.setName(request.getName());
        city.setPostalCode(request.getPostalCode());
        city.setCountry(countryService.findCountryById(request.getCountryId()));

        cityRepository.save(city);
        log.info(BusinessLogMessage.City.CITY_UPDATED + city.getName());
    }

    public void deleteCity(final String id) {
        cityRepository.delete(findCityById(id));
        log.info(BusinessLogMessage.City.CITY_DELETED + id);
    }

    public CityDto findCity(final String id) {
        log.info(BusinessLogMessage.City.CITY_FOUND + id);
        return converter.convert(findCityById(id));
    }

    public List<CityDto> findAllCities() {
        List<City> cities = cityRepository.findAll();

        if (cities.isEmpty()) {
            log.error(BusinessLogMessage.City.CITY_LIST_EMPTY);
            throw new CityListEmptyException(BusinessMessage.City.CITY_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.City.CITY_LISTED);
        return converter.convert(cities);
    }

    private void checkIfCityExists(final String name) {
        if (cityRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.City.CITY_ALREADY_EXISTS + name);
            throw new CityAlreadyExistException(BusinessMessage.City.CITY_ALREADY_EXISTS);
        }
    }

    protected City findCityById(final String id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.City.CITY_NOT_FOUND + id);
                    return new CityNotFoundException(BusinessMessage.City.CITY_NOT_FOUND);
                });
    }
}
