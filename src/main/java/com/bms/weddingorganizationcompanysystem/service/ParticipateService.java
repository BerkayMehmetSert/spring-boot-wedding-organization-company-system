package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.ParticipateDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.ParticipateDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.participate.ParticipateListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.participate.ParticipateNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Participate;
import com.bms.weddingorganizationcompanysystem.repository.ParticipateRepository;
import com.bms.weddingorganizationcompanysystem.request.participate.CreateParticipateRequest;
import com.bms.weddingorganizationcompanysystem.request.participate.UpdateParticipateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ParticipateService {
    private final ParticipateRepository participateRepository;
    private final PersonService personService;
    private final RoleService roleService;
    private final WeddingService weddingService;
    private final ParticipateDtoConverter converter;

    public ParticipateService(ParticipateRepository participateRepository,
                              PersonService personService,
                              RoleService roleService,
                              WeddingService weddingService,
                              ParticipateDtoConverter converter) {
        this.participateRepository = participateRepository;
        this.personService = personService;
        this.roleService = roleService;
        this.weddingService = weddingService;
        this.converter = converter;
    }

    public void createParticipate(final CreateParticipateRequest request) {
        Participate participate = Participate.builder()
                .wedding(weddingService.findWeddingById(request.getWeddingId()))
                .person(personService.findPersonById(request.getPersonId()))
                .role(roleService.findRoleById(request.getRoleId()))
                .build();

        participateRepository.save(participate);
        log.info(BusinessLogMessage.Participate.PARTICIPATE_CREATED + participate.getId());
    }

    public void updateParticipate(final String id, final UpdateParticipateRequest request) {
        Participate participate = findParticipateById(id);

        participate.setPerson(personService.findPersonById(request.getPersonId()));
        participate.setRole(roleService.findRoleById(request.getRoleId()));

        participateRepository.save(participate);
        log.info(BusinessLogMessage.Participate.PARTICIPATE_UPDATED + id);
    }

    public void deleteParticipate(final String id) {
        participateRepository.delete(findParticipateById(id));
        log.info(BusinessLogMessage.Participate.PARTICIPATE_DELETED + id);
    }

    public ParticipateDto findParticipate(final String id) {
        log.info(BusinessLogMessage.Participate.PARTICIPATE_FOUND + id);
        return converter.convert(findParticipateById(id));
    }

    public List<ParticipateDto> findAllParticipates() {
        List<Participate> participates = participateRepository.findAll();

        if (participates.isEmpty()) {
            log.info(BusinessLogMessage.Participate.PARTICIPATE_LIST_EMPTY);
            throw new ParticipateListEmptyException(BusinessMessage.Participate.PARTICIPATE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Participate.PARTICIPATE_LISTED);
        return converter.convert(participates);
    }

    protected Participate findParticipateById(final String id) {
        return participateRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Participate.PARTICIPATE_NOT_FOUND + id);
            throw new ParticipateNotFoundException(BusinessMessage.Participate.PARTICIPATE_NOT_FOUND);
        });
    }
}
