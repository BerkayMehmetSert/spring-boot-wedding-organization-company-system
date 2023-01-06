package com.bms.weddingorganizationcompanysystem.controller;

import com.bms.weddingorganizationcompanysystem.dto.PersonDto;
import com.bms.weddingorganizationcompanysystem.helper.message.ControllerLogMessage;
import com.bms.weddingorganizationcompanysystem.request.person.CreatePersonRequest;
import com.bms.weddingorganizationcompanysystem.request.person.UpdatePersonRequest;
import com.bms.weddingorganizationcompanysystem.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@Slf4j
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<Void> createPerson(@RequestBody CreatePersonRequest request) {
        personService.createPerson(request);

        log.info(ControllerLogMessage.Person.PERSON_CREATED + request.getFirstName() + " " + request.getLastName());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable String id,
                                             @RequestBody UpdatePersonRequest request) {
        personService.updatePerson(id, request);

        log.info(ControllerLogMessage.Person.PERSON_UPDATED + id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
        personService.deletePerson(id);

        log.info(ControllerLogMessage.Person.PERSON_DELETED + id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findPerson(@PathVariable String id) {
        PersonDto person = personService.findPerson(id);

        log.info(ControllerLogMessage.Person.PERSON_FOUND + id);
        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAllPersons() {
        List<PersonDto> persons = personService.findAllPersons();

        log.info(ControllerLogMessage.Person.PERSON_LISTED);
        return ResponseEntity.ok(persons);
    }
}
