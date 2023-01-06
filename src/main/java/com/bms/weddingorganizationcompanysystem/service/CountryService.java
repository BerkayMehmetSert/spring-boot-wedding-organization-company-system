package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.CountryDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.CountryDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.country.CountryAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.country.CountryListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.country.CountryNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Country;
import com.bms.weddingorganizationcompanysystem.repository.CountryRepository;
import com.bms.weddingorganizationcompanysystem.request.country.CreateCountryRequest;
import com.bms.weddingorganizationcompanysystem.request.country.UpdateCountryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;
    private final CountryDtoConverter converter;

    public CountryService(CountryRepository countryRepository,
                          CountryDtoConverter converter) {
        this.countryRepository = countryRepository;
        this.converter = converter;
    }

    public void createCountry(final CreateCountryRequest request) {
        checkIfCountryExists(request.getName());

        Country country = Country.builder()
                .name(request.getName())
                .build();

        countryRepository.save(country);
        log.info(BusinessLogMessage.Country.COUNTRY_CREATED + country.getName());
    }

    public void updateCountry(final String id, final UpdateCountryRequest request) {
        Country country = findCountryById(id);

        if (!country.getName().equals(request.getName())) {
            checkIfCountryExists(request.getName());
        }

        country.setName(request.getName());

        countryRepository.save(country);
        log.info(BusinessLogMessage.Country.COUNTRY_UPDATED + id);
    }

    public void deleteCountry(final String id) {
        countryRepository.delete(findCountryById(id));
        log.info(BusinessLogMessage.Country.COUNTRY_DELETED + id);
    }

    public CountryDto findCountry(final String id) {
        log.info(BusinessLogMessage.Country.COUNTRY_FOUND + id);
        return converter.convert(findCountryById(id));
    }

    public List<CountryDto> findAllCountries() {
        List<Country> countries = countryRepository.findAll();

        if (countries.isEmpty()) {
            log.error(BusinessLogMessage.Country.COUNTRY_LIST_EMPTY);
            throw new CountryListEmptyException(BusinessMessage.Country.COUNTRY_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Country.COUNTRY_LISTED);
        return converter.convert(countries);
    }

    private void checkIfCountryExists(final String name) {
        if (countryRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.Country.COUNTRY_ALREADY_EXISTS);
            throw new CountryAlreadyExistException(BusinessMessage.Country.COUNTRY_ALREADY_EXISTS);
        }
    }

    protected Country findCountryById(final String id) {
        return countryRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Country.COUNTRY_NOT_FOUND);
            throw new CountryNotFoundException(BusinessMessage.Country.COUNTRY_NOT_FOUND);
        });
    }
}
