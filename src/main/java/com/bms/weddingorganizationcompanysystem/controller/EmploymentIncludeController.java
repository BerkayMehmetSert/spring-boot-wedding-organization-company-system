package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentIncludeDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.employmentinclude.CreateEmploymentIncludeRequest;
import com.bms.weddingorganizationcompanysystem.request.employmentinclude.UpdateEmploymentIncludeRequest;
import com.bms.weddingorganizationcompanysystem.service.EmploymentIncludeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employment-includes")
@Slf4j
public class EmploymentIncludeController {
    private final EmploymentIncludeService employmentIncludeService;

    public EmploymentIncludeController(EmploymentIncludeService employmentIncludeService) {
        this.employmentIncludeService = employmentIncludeService;
    }

    @PostMapping
    public ResponseEntity<Void> createEmploymentInclude(@RequestBody CreateEmploymentIncludeRequest request) {
        employmentIncludeService.createEmploymentInclude(request);

        log.info(ControllerLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmploymentInclude(@PathVariable String id,
                                                        @RequestBody UpdateEmploymentIncludeRequest request) {
        employmentIncludeService.updateEmploymentInclude(id, request);

        log.info(ControllerLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploymentInclude(@PathVariable String id) {
        employmentIncludeService.deleteEmploymentInclude(id);

        log.info(ControllerLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentIncludeDto> findEmploymentInclude(@PathVariable String id) {
        EmploymentIncludeDto employmentInclude = employmentIncludeService.findEmploymentInclude(id);

        log.info(ControllerLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_FOUND + id);
        return ResponseEntity.ok(employmentInclude);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentIncludeDto>> findAllEmploymentIncludes() {
        List<EmploymentIncludeDto> employmentIncludes = employmentIncludeService.findAllEmploymentIncludes();

        log.info(ControllerLogMessage.EmploymentInclude.EMPLOYMENT_INCLUDE_LISTED);
        return ResponseEntity.ok(employmentIncludes);
    }
}
