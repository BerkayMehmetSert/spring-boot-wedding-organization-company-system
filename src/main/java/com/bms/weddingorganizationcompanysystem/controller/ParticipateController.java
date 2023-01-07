package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.ParticipateDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.participate.CreateParticipateRequest;
import com.bms.weddingorganizationcompanysystem.request.participate.UpdateParticipateRequest;
import com.bms.weddingorganizationcompanysystem.service.ParticipateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participate")
@Slf4j
public class ParticipateController {
    private final ParticipateService participateService;

    public ParticipateController(ParticipateService participateService) {
        this.participateService = participateService;
    }

    @PostMapping
    public ResponseEntity<Void> createParticipate(@RequestBody CreateParticipateRequest request) {
        participateService.createParticipate(request);

        log.info(ControllerLogMessage.Participate.PARTICIPATE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateParticipate(@PathVariable String id,
                                                  @RequestBody UpdateParticipateRequest request) {
        participateService.updateParticipate(id, request);

        log.info(ControllerLogMessage.Participate.PARTICIPATE_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipate(@PathVariable String id) {
        participateService.deleteParticipate(id);

        log.info(ControllerLogMessage.Participate.PARTICIPATE_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipateDto> findParticipate(@PathVariable String id) {
        ParticipateDto participate = participateService.findParticipate(id);

        log.info(ControllerLogMessage.Participate.PARTICIPATE_FOUND + id);
        return ResponseEntity.ok(participate);
    }

    @GetMapping
    public ResponseEntity<List<ParticipateDto>> findAllParticipates() {
        List<ParticipateDto> participates = participateService.findAllParticipates();

        log.info(ControllerLogMessage.Participate.PARTICIPATE_LISTED);
        return ResponseEntity.ok(participates);
    }
}
