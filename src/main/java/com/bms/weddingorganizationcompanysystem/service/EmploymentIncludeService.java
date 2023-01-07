package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentIncludeDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.EmploymentIncludeDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.employmentinclude.EmploymentIncludeListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.employmentinclude.EmploymentIncludeNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.EmploymentInclude;
import com.bms.weddingorganizationcompanysystem.repository.EmploymentIncludeRepository;
import com.bms.weddingorganizationcompanysystem.request.employmentinclude.CreateEmploymentIncludeRequest;
import com.bms.weddingorganizationcompanysystem.request.employmentinclude.UpdateEmploymentIncludeRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmploymentIncludeService {
    private final EmploymentIncludeRepository employmentIncludeRepository;
    private final StatusService statusService;
    private final EventService eventService;
    private final EmploymentProviderService employmentProviderService;
    private final EmploymentIncludeDtoConverter converter;

    public EmploymentIncludeService(EmploymentIncludeRepository employmentIncludeRepository,
                                    StatusService statusService,
                                    EventService eventService,
                                    EmploymentProviderService employmentProviderService,
                                    EmploymentIncludeDtoConverter converter) {
        this.employmentIncludeRepository = employmentIncludeRepository;
        this.statusService = statusService;
        this.eventService = eventService;
        this.employmentProviderService = employmentProviderService;
        this.converter = converter;
    }

    public void createEmploymentInclude(final CreateEmploymentIncludeRequest request) {
        EmploymentInclude employmentInclude = EmploymentInclude.builder()
                .price(request.getPrice())
                .status(statusService.findStatusById(request.getStatusId()))
                .event(eventService.findEventById(request.getEventId()))
                .employmentProvider(employmentProviderService
                        .findEmploymentProviderById(request.getEmploymentProviderId()))
                .build();

        employmentIncludeRepository.save(employmentInclude);
        log.info(BusinessLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_CREATED + employmentInclude.getId());
    }

    public void updateEmploymentInclude(final String id, final UpdateEmploymentIncludeRequest request) {
        EmploymentInclude employmentInclude = findEmploymentIncludeById(id);

        employmentInclude.setPrice(request.getPrice());
        employmentInclude.setStatus(statusService.findStatusById(request.getStatusId()));

        employmentIncludeRepository.save(employmentInclude);
        log.info(BusinessLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_UPDATED + employmentInclude.getId());
    }

    public void deleteEmploymentInclude(final String id) {
        employmentIncludeRepository.delete(findEmploymentIncludeById(id));
        log.info(BusinessLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_DELETED + id);
    }

    public EmploymentIncludeDto findEmploymentInclude(final String id) {
        log.info(BusinessLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_FOUND + id);
        return converter.convert(findEmploymentIncludeById(id));
    }

    public List<EmploymentIncludeDto> findAllEmploymentIncludes() {
        List<EmploymentInclude> employmentIncludes = employmentIncludeRepository.findAll();

        if (employmentIncludes.isEmpty()) {
            log.error(BusinessLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_LIST_EMPTY);
            throw new EmploymentIncludeListEmptyException(BusinessMessage
                    .EmploymentInclude.EMPLOYMENT_INCLUDE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_LISTED);
        return converter.convert(employmentIncludeRepository.findAll());
    }

    protected EmploymentInclude findEmploymentIncludeById(final String id) {
        return employmentIncludeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_NOT_FOUND + id);
                    throw new EmploymentIncludeNotFoundException(
                            BusinessMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_NOT_FOUND + id);
                });
    }
}
