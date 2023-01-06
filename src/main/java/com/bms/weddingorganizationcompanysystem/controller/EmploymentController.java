package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.EmploymentDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.employment.CreateEmploymentRequest;
import com.bms.weddingorganizationcompanysystem.request.employment.UpdateEmploymentRequest;
import com.bms.weddingorganizationcompanysystem.service.EmploymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employment")
@Slf4j
public class EmploymentController {
    private final EmploymentService employmentService;

    public EmploymentController(EmploymentService employmentService) {
        this.employmentService = employmentService;
    }

    @PostMapping
    public ResponseEntity<Void> createEmployment(@RequestBody CreateEmploymentRequest request) {
        employmentService.createEmployment(request);

        log.info(ControllerLogMessage.Employment.EMPLOYMENT_CREATED + request.getServiceName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/pdf")
    public ResponseEntity<InputStreamResource> generatePdf(@PathVariable String id) {
        ByteArrayInputStream pdf = employmentService.generatePdf(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + id + ".pdf");

        log.info(ControllerLogMessage.Employment.EMPLOYMENT_PDF_CREATED + id);
        return ResponseEntity.ok().headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdf));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployment(@PathVariable String id,
                                                 @RequestBody UpdateEmploymentRequest request) {
        employmentService.updateEmployment(id, request);

        log.info(ControllerLogMessage.Employment.EMPLOYMENT_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployment(@PathVariable String id) {
        employmentService.deleteEmployment(id);

        log.info(ControllerLogMessage.Employment.EMPLOYMENT_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentDto> findEmployment(@PathVariable String id) {
        EmploymentDto employment = employmentService.findEmployment(id);

        log.info(ControllerLogMessage.Employment.EMPLOYMENT_FOUND + id);
        return ResponseEntity.ok(employment);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentDto>> findAllEmployments() {
        List<EmploymentDto> employments = employmentService.findAllEmployments();

        log.info(ControllerLogMessage.Employment.EMPLOYMENT_LISTED);
        return ResponseEntity.ok(employments);
    }
}
