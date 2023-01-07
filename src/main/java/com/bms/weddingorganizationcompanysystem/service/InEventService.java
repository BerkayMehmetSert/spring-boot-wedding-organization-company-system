package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.InEventDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.InEventDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.inevent.InEventListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.inevent.InEventNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.InEvent;
import com.bms.weddingorganizationcompanysystem.repository.InEventRepository;
import com.bms.weddingorganizationcompanysystem.request.inevent.CreateInEventRequest;
import com.bms.weddingorganizationcompanysystem.request.inevent.UpdateInEventRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InEventService {
    private final InEventRepository inEventRepository;
    private final EventService eventService;
    private final ParticipateService participateService;
    private final InEventDtoConverter converter;

    public InEventService(InEventRepository inEventRepository,
                          EventService eventService,
                          ParticipateService participateService,
                          InEventDtoConverter converter) {
        this.inEventRepository = inEventRepository;
        this.eventService = eventService;
        this.participateService = participateService;
        this.converter = converter;
    }

    public void createInEvent(final CreateInEventRequest request) {
        InEvent inEvent = InEvent.builder()
                .detail(request.getDetail())
                .event(eventService.findEventById(request.getEventId()))
                .participate(participateService.findParticipateById(request.getParticipateId()))
                .build();

        inEventRepository.save(inEvent);
        log.info(BusinessLogMessage.InEvent.IN_EVENT_CREATED + inEvent.getId());
    }

    public void updateInEvent(final String id, final UpdateInEventRequest request){
        InEvent inEvent = findInEventById(id);

        inEvent.setDetail(request.getDetail());

        inEventRepository.save(inEvent);
        log.info(BusinessLogMessage.InEvent.IN_EVENT_UPDATED + inEvent.getId());
    }

    public void deleteInEvent(final String id){
        inEventRepository.delete(findInEventById(id));
        log.info(BusinessLogMessage.InEvent.IN_EVENT_DELETED + id);
    }

    public InEventDto findInEvent(final String id){
        log.info(BusinessLogMessage.InEvent.IN_EVENT_FOUND + id);
        return converter.convert(findInEventById(id));
    }

    public List<InEventDto> findAllInEvents(){
        List<InEvent> inEvents = inEventRepository.findAll();

        if (inEvents.isEmpty()){
            log.error(BusinessMessage.InEvent.IN_EVENT_LIST_EMPTY);
            throw new InEventListEmptyException(BusinessMessage.InEvent.IN_EVENT_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.InEvent.IN_EVENT_LISTED);
        return converter.convert(inEvents);
    }
    protected InEvent findInEventById(final String id) {
        return inEventRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.InEvent.IN_EVENT_NOT_FOUND + id);
            throw new InEventNotFoundException(BusinessMessage.InEvent.IN_EVENT_NOT_FOUND);
        });
    }
}
