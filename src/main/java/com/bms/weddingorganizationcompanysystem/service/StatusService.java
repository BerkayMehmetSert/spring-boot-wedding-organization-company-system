package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.StatusDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.StatusDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.status.StatusAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.status.StatusListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.status.StatusNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Status;
import com.bms.weddingorganizationcompanysystem.repository.StatusRepository;
import com.bms.weddingorganizationcompanysystem.request.status.CreateStatusRequest;
import com.bms.weddingorganizationcompanysystem.request.status.UpdateStatusRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StatusService {
    private final StatusRepository statusRepository;
    private final StatusDtoConverter converter;

    public StatusService(StatusRepository statusRepository,
                         StatusDtoConverter converter) {
        this.statusRepository = statusRepository;
        this.converter = converter;
    }

    public void createStatus(final CreateStatusRequest request) {
        checkIfStatusExists(request.getName());

        Status status = Status.builder()
                .name(request.getName())
                .offer(request.getOffer())
                .offerAccepted(request.getOfferAccepted())
                .offerRejected(request.getOfferRejected())
                .build();

        statusRepository.save(status);
        log.info(BusinessLogMessage.Status.STATUS_CREATED + request.getName());
    }


    public void updateStatus(final String id, final UpdateStatusRequest request) {
        Status status = findStatusById(id);

        if (!status.getName().equals(request.getName())) {
            checkIfStatusExists(request.getName());
        }

        status.setName(request.getName());
        status.setOffer(request.getOffer());
        status.setOfferAccepted(request.getOfferAccepted());
        status.setOfferRejected(request.getOfferRejected());

        statusRepository.save(status);
        log.info(BusinessLogMessage.Status.STATUS_UPDATED + id);
    }

    public void completeStatus(final String id) {
        Status status = findStatusById(id);
        status.setOffer(true);
        status.setOfferAccepted(true);
        status.setOfferRejected(true);

        statusRepository.save(status);
        log.info(BusinessLogMessage.Status.STATUS_COMPLETED + id);
    }

    public void deleteStatus(final String id) {
        statusRepository.delete(findStatusById(id));
        log.info(BusinessLogMessage.Status.STATUS_DELETED + id);
    }

    public StatusDto findStatus(final String id) {
        log.info(BusinessLogMessage.Status.STATUS_FOUND + id);
        return converter.convert(findStatusById(id));
    }

    public List<StatusDto> findAllStatuses() {
        List<Status> statuses = statusRepository.findAll();

        if (statuses.isEmpty()) {
            log.error(BusinessLogMessage.Status.STATUS_LIST_EMPTY);
            throw new StatusListEmptyException(BusinessMessage.Status.STATUS_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Status.STATUS_LISTED);
        return converter.convert(statuses);
    }

    protected Status findStatusById(final String id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Status.STATUS_NOT_FOUND + id);
                    throw new StatusNotFoundException(BusinessLogMessage.Status.STATUS_NOT_FOUND + id);
                });
    }

    private void checkIfStatusExists(final String name) {
        if (statusRepository.existsByNameIgnoreCase(name)) {
            log.error(BusinessLogMessage.Status.STATUS_ALREADY_EXISTS + name);
            throw new StatusAlreadyExistException(BusinessMessage.Status.STATUS_ALREADY_EXISTS);
        }
    }
}
