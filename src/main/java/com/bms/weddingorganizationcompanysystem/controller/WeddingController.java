package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.WeddingDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.wedding.CreateWeddingRequest;
import com.bms.weddingorganizationcompanysystem.request.wedding.UpdateWeddingRequest;
import com.bms.weddingorganizationcompanysystem.service.WeddingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wedding")
@Slf4j
public class WeddingController {
    private final WeddingService weddingService;

    public WeddingController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }

    @PostMapping
    public ResponseEntity<Void> createWedding(@RequestBody CreateWeddingRequest request) {
        weddingService.createWedding(request);

        log.info(ControllerLogMessage.Wedding.WEDDING_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateWedding(@PathVariable String id,
                                              @RequestBody UpdateWeddingRequest request) {
        weddingService.updateWedding(id, request);

        log.info(ControllerLogMessage.Wedding.WEDDING_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Void> completeWedding(@PathVariable String id) {
        weddingService.completeWedding(id);

        log.info(ControllerLogMessage.Wedding.WEDDING_COMPLETED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWedding(@PathVariable String id) {
        weddingService.deleteWedding(id);

        log.info(ControllerLogMessage.Wedding.WEDDING_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeddingDto> findWeddingById(@PathVariable String id) {
        WeddingDto wedding = weddingService.findWedding(id);

        log.info(ControllerLogMessage.Wedding.WEDDING_FOUND + id);
        return ResponseEntity.ok(wedding);
    }

    @GetMapping
    public ResponseEntity<List<WeddingDto>> findAllWeddings() {
        List<WeddingDto> weddings = weddingService.findAllWeddings();

        log.info(ControllerLogMessage.Wedding.WEDDING_LISTED);
        return ResponseEntity.ok(weddings);
    }

}
