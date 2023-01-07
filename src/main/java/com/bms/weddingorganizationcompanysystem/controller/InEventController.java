package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.InEventDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.inevent.CreateInEventRequest;
import com.bms.weddingorganizationcompanysystem.request.inevent.UpdateInEventRequest;
import com.bms.weddingorganizationcompanysystem.service.InEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/in-event")
@Slf4j
public class InEventController {
    private final InEventService inEventService;

    public InEventController(InEventService inEventService) {
        this.inEventService = inEventService;
    }

    @PostMapping
    public ResponseEntity<Void> createInEvent(@RequestBody CreateInEventRequest request) {
        inEventService.createInEvent(request);

        log.info(ControllerLogMessage.InEvent.IN_EVENT_CREATED + request.getEventId());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInEvent(@PathVariable String id,
                                              @RequestBody UpdateInEventRequest request) {
        inEventService.updateInEvent(id, request);

        log.info(ControllerLogMessage.InEvent.IN_EVENT_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInEvent(@PathVariable String id) {
        inEventService.deleteInEvent(id);

        log.info(ControllerLogMessage.InEvent.IN_EVENT_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InEventDto> findInEvent(@PathVariable String id) {
        InEventDto inEvent = inEventService.findInEvent(id);

        log.info(ControllerLogMessage.InEvent.IN_EVENT_FOUND + id);
        return ResponseEntity.ok(inEvent);
    }

    @GetMapping
    public ResponseEntity<List<InEventDto>> findAllInEvent() {
        List<InEventDto> inEvents = inEventService.findAllInEvents();

        log.info(ControllerLogMessage.InEvent.IN_EVENT_LISTED);
        return ResponseEntity.ok(inEvents);
    }
}
