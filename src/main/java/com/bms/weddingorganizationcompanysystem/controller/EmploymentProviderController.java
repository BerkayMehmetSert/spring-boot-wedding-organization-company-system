package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentProviderDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.employmentprovider.CreateEmploymentProviderRequest;
import com.bms.weddingorganizationcompanysystem.request.employmentprovider.UpdateEmploymentProviderRequest;
import com.bms.weddingorganizationcompanysystem.service.EmploymentProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employment-provider")
@Slf4j
public class EmploymentProviderController {
    private final EmploymentProviderService employmentProviderService;

    public EmploymentProviderController(EmploymentProviderService employmentProviderService) {
        this.employmentProviderService = employmentProviderService;
    }

    @PostMapping
    public ResponseEntity<Void> createEmploymentProvider(@RequestBody CreateEmploymentProviderRequest request) {
        employmentProviderService.createEmploymentProvider(request);

        log.info(ControllerLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_CREATED + request.getEmploymentId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmploymentProvider(@PathVariable String id,
                                                         @RequestBody UpdateEmploymentProviderRequest request) {
        employmentProviderService.updateEmploymentProvider(id, request);

        log.info(ControllerLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploymentProvider(@PathVariable String id) {
        employmentProviderService.deleteEmploymentProvider(id);

        log.info(ControllerLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentProviderDto> findEmploymentProvider(@PathVariable String id) {
        EmploymentProviderDto employmentProvider = employmentProviderService.findEmploymentProvider(id);

        log.info(ControllerLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_FOUND + id);
        return ResponseEntity.ok(employmentProvider);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentProviderDto>> findAllEmploymentProviders() {
        List<EmploymentProviderDto> employmentProviders = employmentProviderService.findAllEmploymentProviders();

        log.info(ControllerLogMessage.EmploymentProvider.EMPLOYMENT_PROVIDER_LISTED);
        return ResponseEntity.ok(employmentProviders);
    }
}
