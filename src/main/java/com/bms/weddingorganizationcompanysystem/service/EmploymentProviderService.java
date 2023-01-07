package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentProviderDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.EmploymentProviderDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.employmentprovider.EmploymentProviderListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.employmentprovider.EmploymentProviderNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.EmploymentProvider;
import com.bms.weddingorganizationcompanysystem.repository.EmploymentProviderRepository;
import com.bms.weddingorganizationcompanysystem.request.employmentprovider.CreateEmploymentProviderRequest;
import com.bms.weddingorganizationcompanysystem.request.employmentprovider.UpdateEmploymentProviderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmploymentProviderService {
    private final EmploymentProviderRepository employmentProviderRepository;
    private final EmploymentService employmentService;
    private final PartnerService partnerService;
    private final EmploymentProviderDtoConverter converter;

    public EmploymentProviderService(EmploymentProviderRepository employmentProviderRepository,
                                     EmploymentService employmentService,
                                     PartnerService partnerService,
                                     EmploymentProviderDtoConverter converter) {
        this.employmentProviderRepository = employmentProviderRepository;
        this.employmentService = employmentService;
        this.partnerService = partnerService;
        this.converter = converter;
    }

    public void createEmploymentProvider(final CreateEmploymentProviderRequest request) {
        EmploymentProvider employmentProvider = EmploymentProvider.builder()
                .detail(request.getDetail())
                .isActive(true)
                .employment(employmentService.findEmploymentById(request.getEmploymentId()))
                .partner(partnerService.findPartnerById(request.getPartnerId()))
                .build();

        employmentProviderRepository.save(employmentProvider);
        log.info(BusinessLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_CREATED + employmentProvider.getId());
    }

    public void updateEmploymentProvider(final String id, final UpdateEmploymentProviderRequest request) {
        EmploymentProvider employmentProvider = findEmploymentProviderById(id);

        employmentProvider.setDetail(request.getDetail());
        employmentProvider.setEmployment(employmentService.findEmploymentById(request.getEmploymentId()));
        employmentProvider.setPartner(partnerService.findPartnerById(request.getPartnerId()));

        employmentProviderRepository.save(employmentProvider);
        log.info(BusinessLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_UPDATED + id);
    }

    public void deleteEmploymentProvider(final String id) {
        EmploymentProvider employmentProvider = findEmploymentProviderById(id);

        employmentProvider.setIsActive(false);

        employmentProviderRepository.save(employmentProvider);
        log.info(BusinessLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_DELETED + id);
    }

    public EmploymentProviderDto findEmploymentProvider(final String id) {
        log.info(BusinessLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_FOUND + id);
        return converter.convert(findEmploymentProviderById(id));
    }

    public List<EmploymentProviderDto> findAllEmploymentProviders() {
        List<EmploymentProvider> employmentProviders = employmentProviderRepository.findAll().stream()
                .filter(x -> x.getIsActive().equals(true))
                .toList();

        if (employmentProviders.isEmpty()) {
            log.error(BusinessLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_LIST_EMPTY);
            throw new EmploymentProviderListEmptyException(BusinessMessage
                    .EmploymentProvider.EMPLOYMENT_PROVIDER_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_LISTED);
        return converter.convert(employmentProviders);
    }

    protected EmploymentProvider findEmploymentProviderById(final String id) {
        return employmentProviderRepository.findById(id)
                .filter(x -> x.getIsActive().equals(true))
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_NOT_FOUND + id);
                    throw new EmploymentProviderNotFoundException(BusinessMessage
                            .EmploymentProvider.EMPLOYMENT_PROVIDER_NOT_FOUND);
                });
    }
}
