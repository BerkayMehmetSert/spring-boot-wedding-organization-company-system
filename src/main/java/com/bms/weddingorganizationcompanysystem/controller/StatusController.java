package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.StatusDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.status.CreateStatusRequest;
import com.bms.weddingorganizationcompanysystem.request.status.UpdateStatusRequest;
import com.bms.weddingorganizationcompanysystem.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/status")
@Slf4j
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseEntity<Void> createStatus(@RequestBody CreateStatusRequest request) {
        statusService.createStatus(request);

        log.info(ControllerLogMessage.Status.STATUS_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable String id,
                                             @RequestBody UpdateStatusRequest request) {
        statusService.updateStatus(id, request);

        log.info(ControllerLogMessage.Status.STATUS_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Void> completeStatus(@PathVariable String id) {
        statusService.completeStatus(id);

        log.info(ControllerLogMessage.Status.STATUS_COMPLETED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable String id) {
        statusService.deleteStatus(id);

        log.info(ControllerLogMessage.Status.STATUS_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> findStatus(@PathVariable String id) {
        StatusDto status = statusService.findStatus(id);

        log.info(ControllerLogMessage.Status.STATUS_FOUND + id);
        return ResponseEntity.ok(status);
    }

    @GetMapping
    public ResponseEntity<List<StatusDto>> findAllStatuses() {
        List<StatusDto> statuses = statusService.findAllStatuses();

        log.info(ControllerLogMessage.Status.STATUS_LISTED);
        return ResponseEntity.ok(statuses);
    }
}
