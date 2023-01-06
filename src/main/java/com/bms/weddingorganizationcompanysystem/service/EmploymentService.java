package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.EmploymentDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.employment.EmploymentAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.employment.EmploymentListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.employment.EmploymentNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.Generator;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Employment;
import com.bms.weddingorganizationcompanysystem.repository.EmploymentRepository;
import com.bms.weddingorganizationcompanysystem.request.employment.CreateEmploymentRequest;
import com.bms.weddingorganizationcompanysystem.request.employment.UpdateEmploymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
@Slf4j
public class EmploymentService {
    private final EmploymentRepository employmentRepository;
    private final PdfService pdfService;
    private final EmploymentDtoConverter converter;

    public EmploymentService(EmploymentRepository employmentRepository,
                             PdfService pdfService,
                             EmploymentDtoConverter converter) {
        this.employmentRepository = employmentRepository;
        this.pdfService = pdfService;
        this.converter = converter;
    }

    public void createEmployment(final CreateEmploymentRequest request) {
        checkEmploymentExists(request.getServiceName());

        Employment employment = Employment.builder()
                .serviceCode(Generator.generateCode())
                .serviceName(request.getServiceName())
                .description(request.getDescription())
                .picture(request.getPicture())
                .build();

        employmentRepository.save(employment);
        log.info(BusinessLogMessage.Employment.EMPLOYMENT_CREATED + employment.getServiceName());
    }

    public ByteArrayInputStream generatePdf(final String id) {
        log.info(BusinessLogMessage.Employment.EMPLOYMENT_PDF_GENERATED + id);
        return pdfService.generatePdf(findEmploymentById(id));
    }
    public void updateEmployment(final String id, final UpdateEmploymentRequest request) {
        Employment employment = findEmploymentById(id);

        if (!employment.getServiceName().equals(request.getServiceName())) {
            checkEmploymentExists(request.getServiceName());
        }

        employment.setServiceName(request.getServiceName());
        employment.setDescription(request.getDescription());
        employment.setPicture(request.getPicture());

        employmentRepository.save(employment);
        log.info(BusinessLogMessage.Employment.EMPLOYMENT_UPDATED + employment.getServiceName());
    }

    public void deleteEmployment(final String id) {
        employmentRepository.delete(findEmploymentById(id));
        log.info(BusinessLogMessage.Employment.EMPLOYMENT_DELETED + id);
    }

    public EmploymentDto findEmployment(final String id) {
        log.info(BusinessLogMessage.Employment.EMPLOYMENT_FOUND + id);
        return converter.convert(findEmploymentById(id));
    }

    public List<EmploymentDto> findAllEmployments() {
        List<Employment> employments = employmentRepository.findAll();

        if (employments.isEmpty()) {
            log.error(BusinessLogMessage.Employment.EMPLOYMENT_LIST_EMPTY);
            throw new EmploymentListEmptyException(BusinessMessage.Employment.EMPLOYMENT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Employment.EMPLOYMENT_LISTED);
        return converter.convert(employments);
    }

    protected Employment findEmploymentById(final String id) {
        return employmentRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Employment.EMPLOYMENT_NOT_FOUND + id);
            throw new EmploymentNotFoundException(BusinessMessage.Employment.EMPLOYMENT_NOT_FOUND + id);
        });
    }

    private void checkEmploymentExists(final String serviceName) {
        if (employmentRepository.existsByServiceNameIgnoreCase(serviceName)) {
            log.error(BusinessLogMessage.Employment.EMPLOYMENT_ALREADY_EXISTS + serviceName);
            throw new EmploymentAlreadyExistException(BusinessMessage.Employment.EMPLOYMENT_ALREADY_EXISTS);
        }
    }
}
