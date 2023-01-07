package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.PartnerDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.partner.CreatePartnerRequest;
import com.bms.weddingorganizationcompanysystem.request.partner.UpdatePartnerRequest;
import com.bms.weddingorganizationcompanysystem.service.PartnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partner")
@Slf4j
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping
    public ResponseEntity<Void> createPartner(@RequestBody CreatePartnerRequest request) {
        partnerService.createPartner(request);

        log.info(ControllerLogMessage.Partner.PARTNER_CREATED + request.getName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePartner(@PathVariable String id,
                                              @RequestBody UpdatePartnerRequest request) {
        partnerService.updatePartner(id, request);

        log.info(ControllerLogMessage.Partner.PARTNER_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable String id) {
        partnerService.deletePartner(id);

        log.info(ControllerLogMessage.Partner.PARTNER_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartnerDto> findPartner(@PathVariable String id) {
        PartnerDto partner = partnerService.findPartner(id);

        log.info(ControllerLogMessage.Partner.PARTNER_FOUND + id);
        return ResponseEntity.ok(partner);
    }

    @GetMapping
    public ResponseEntity<List<PartnerDto>> findAllPartners() {
        List<PartnerDto> partners = partnerService.findAllPartners();

        log.info(ControllerLogMessage.Partner.PARTNER_LISTED);
        return ResponseEntity.ok(partners);
    }
}
