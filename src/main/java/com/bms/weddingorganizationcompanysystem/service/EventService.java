package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.EventDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.EventDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.event.EventNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.DateHelper;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Event;
import com.bms.weddingorganizationcompanysystem.repository.EventRepository;
import com.bms.weddingorganizationcompanysystem.request.event.UpdateEventRequest;
import com.bms.weddingorganizationcompanysystem.request.event.CreateEventRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventService {
    private final EventRepository eventRepository;
    private final LocationService locationService;
    private final WeddingService weddingService;
    private final EventDtoConverter converter;

    public EventService(EventRepository eventRepository,
                        LocationService locationService,
                        WeddingService weddingService,
                        EventDtoConverter converter) {
        this.eventRepository = eventRepository;
        this.locationService = locationService;
        this.weddingService = weddingService;
        this.converter = converter;
    }

    public void createEvent(final CreateEventRequest request) {
        Event event = Event.builder()
                .name(request.getName())
                .startTimePlanned(request.getStartTimePlanned())
                .endTimePlanned(request.getEndTimePlanned())
                .startTime(DateHelper.getCurrentDateTime())
                .budgePlanned(request.getBudgePlanned())
                .location(locationService.findLocationById(request.getLocationId()))
                .wedding(weddingService.findWeddingById(request.getWeddingId()))
                .build();

        eventRepository.save(event);
        log.info(BusinessLogMessage.Event.EVENT_CREATED + request.getName());
    }

    public void updateEvent(final String id, final UpdateEventRequest request) {
        Event event = findEventById(id);

        event.setName(request.getName());
        event.setStartTimePlanned(request.getStartTimePlanned());
        event.setEndTimePlanned(request.getEndTimePlanned());
        event.setBudgePlanned(request.getBudgePlanned());
        event.setLocation(locationService.findLocationById(request.getLocationId()));

        eventRepository.save(event);
        log.info(BusinessLogMessage.Event.EVENT_UPDATED + request.getName());
    }

    public void completeEvent(final String id) {
        Event event = findEventById(id);

        event.setEndTime(DateHelper.getCurrentDateTime());
        eventRepository.save(event);
        log.info(BusinessLogMessage.Event.EVENT_COMPLETED + id);
    }

    public void deleteEvent(final String id) {
        eventRepository.delete(findEventById(id));
        log.info(BusinessLogMessage.Event.EVENT_DELETED + id);
    }

    public EventDto findEvent(final String id) {
        log.info(BusinessLogMessage.Event.EVENT_FOUND + id);
        return converter.convert(findEventById(id));
    }

    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();

        if (events.isEmpty()) {
            log.info(BusinessLogMessage.Event.EVENT_LIST_EMPTY);
            throw new EventNotFoundException(BusinessMessage.Event.EVENT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Event.EVENT_LISTED);
        return converter.convert(events);
    }

    protected Event findEventById(final String id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Event.EVENT_NOT_FOUND + id);
                    throw new EventNotFoundException(BusinessMessage.Event.EVENT_NOT_FOUND);
                });
    }
}
