package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.PartnerDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.PartnerDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.partner.PartnerNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.Generator;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Partner;
import com.bms.weddingorganizationcompanysystem.repository.PartnerRepository;
import com.bms.weddingorganizationcompanysystem.request.partner.CreatePartnerRequest;
import com.bms.weddingorganizationcompanysystem.request.partner.UpdatePartnerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PartnerService {
    private final PartnerRepository partnerRepository;
    private final PartnerDtoConverter converter;

    public PartnerService(PartnerRepository partnerRepository,
                          PartnerDtoConverter converter) {
        this.partnerRepository = partnerRepository;
        this.converter = converter;
    }

    public void createPartner(final CreatePartnerRequest request) {
        Partner partner = Partner.builder()
                .partnerCode(Generator.generateCode())
                .name(request.getName())
                .build();

        partnerRepository.save(partner);
        log.info(BusinessLogMessage.Partner.PARTNER_CREATED + request.getName());
    }

    public void updatePartner(final String id, final UpdatePartnerRequest request) {
        Partner partner = findPartnerById(id);

        partner.setName(request.getName());
        partnerRepository.save(partner);
        log.info(BusinessLogMessage.Partner.PARTNER_UPDATED + id);
    }

    public void deletePartner(final String id) {
        partnerRepository.delete(findPartnerById(id));
        log.info(BusinessLogMessage.Partner.PARTNER_DELETED + id);
    }

    public PartnerDto findPartner(final String id) {
        log.info(BusinessLogMessage.Partner.PARTNER_FOUND + id);
        return converter.convert(findPartnerById(id));
    }

    public List<PartnerDto> findAllPartners(){
        List<Partner> partners = partnerRepository.findAll();

        if (partners.isEmpty()) {
            log.info(BusinessLogMessage.Partner.PARTNER_LIST_EMPTY);
            throw new PartnerNotFoundException(BusinessMessage.Partner.PARTNER_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Partner.PARTNER_LISTED);
        return converter.convert(partners);
    }

    protected Partner findPartnerById(final String id) {
        return partnerRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(BusinessLogMessage.Partner.PARTNER_NOT_FOUND + id);
                    throw new PartnerNotFoundException(BusinessMessage.Partner.PARTNER_NOT_FOUND);
                });
    }
}
