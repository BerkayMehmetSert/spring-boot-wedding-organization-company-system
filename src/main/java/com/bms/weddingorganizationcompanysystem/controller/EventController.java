package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.EventDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.event.CreateEventRequest;
import com.bms.weddingorganizationcompanysystem.request.event.UpdateEventRequest;
import com.bms.weddingorganizationcompanysystem.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@Slf4j
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Void> createEvent(@RequestBody CreateEventRequest request) {
        eventService.createEvent(request);

        log.info(ControllerLogMessage.Event.EVENT_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvent(@PathVariable String id,
                                            @RequestBody UpdateEventRequest request) {
        eventService.updateEvent(id, request);

        log.info(ControllerLogMessage.Event.EVENT_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Void> completeEvent(@PathVariable String id) {
        eventService.completeEvent(id);

        log.info(ControllerLogMessage.Event.EVENT_COMPLETED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);

        log.info(ControllerLogMessage.Event.EVENT_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> findEvent(@PathVariable String id) {
        EventDto event = eventService.findEvent(id);

        log.info(ControllerLogMessage.Event.EVENT_FOUND + id);
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<List<EventDto>> findAllEvents() {
        List<EventDto> events = eventService.findAllEvents();

        log.info(ControllerLogMessage.Event.EVENT_LISTED);
        return ResponseEntity.ok(events);
    }
}
