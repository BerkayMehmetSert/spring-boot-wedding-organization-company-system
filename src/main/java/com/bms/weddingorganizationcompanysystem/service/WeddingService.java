package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.WeddingDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.WeddingDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.wedding.WeddingListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.wedding.WeddingNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.DateHelper;
import com.bms.weddingorganizationcompanysystem.helper.Generator;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Wedding;
import com.bms.weddingorganizationcompanysystem.repository.WeddingRepository;
import com.bms.weddingorganizationcompanysystem.request.wedding.CreateWeddingRequest;
import com.bms.weddingorganizationcompanysystem.request.wedding.UpdateWeddingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WeddingService {
    private final WeddingRepository weddingRepository;
    private final WeddingDtoConverter converter;

    public WeddingService(WeddingRepository weddingRepository,
                          WeddingDtoConverter converter) {
        this.weddingRepository = weddingRepository;
        this.converter = converter;
    }

    public void createWedding(final CreateWeddingRequest request) {
        Wedding wedding = Wedding.builder()
                .weddingCode(Generator.generateCode())
                .startTimePlanned(request.getStartTimePlanned())
                .endTimePlanned(request.getEndTimePlanned())
                .startTime(request.getStartTime())
                .endTime(request.getEndTimePlanned())
                .budgePlanned(request.getBudgePlanned())
                .build();

        weddingRepository.save(wedding);
        log.info(BusinessLogMessage.Wedding.WEDDING_CREATED);
    }

    public void updateWedding(final String id, final UpdateWeddingRequest request) {
        Wedding wedding = findWeddingById(id);

        wedding.setStartTimePlanned(request.getStartTimePlanned());
        wedding.setEndTimePlanned(request.getEndTimePlanned());
        wedding.setStartTime(request.getStartTime());
        wedding.setEndTime(request.getEndTimePlanned());
        wedding.setBudgePlanned(request.getBudgePlanned());

        weddingRepository.save(wedding);
        log.info(BusinessLogMessage.Wedding.WEDDING_UPDATED + id);
    }

    public void completeWedding(final String id) {
        Wedding wedding = findWeddingById(id);

        wedding.setEndTime(DateHelper.getCurrentDateTime());
        weddingRepository.save(wedding);
        log.info(BusinessLogMessage.Wedding.WEDDING_COMPLETED + id);
    }

    public void deleteWedding(final String id) {
        weddingRepository.delete(findWeddingById(id));
        log.info(BusinessLogMessage.Wedding.WEDDING_DELETED + id);
    }

    public WeddingDto findWedding(final String id) {
        log.info(BusinessLogMessage.Wedding.WEDDING_FOUND + id);
        return converter.convert(findWeddingById(id));
    }

    public List<WeddingDto> findAllWeddings() {
        List<Wedding> weddings = weddingRepository.findAll();

        if (weddings.isEmpty()) {
            log.error(BusinessLogMessage.Wedding.WEDDING_LIST_EMPTY);
            throw new WeddingListEmptyException(BusinessMessage.Wedding.WEDDING_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Wedding.WEDDING_LISTED);
        return converter.convert(weddings);
    }

    protected Wedding findWeddingById(final String id) {
        return weddingRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Wedding.WEDDING_NOT_FOUND + id);
                    throw new WeddingNotFoundException(BusinessMessage.Wedding.WEDDING_NOT_FOUND);
                });
    }
}
