package com.bms.weddingorganizationcompanysystem.service;

import com.bms.weddingorganizationcompanysystem.dto.PersonDto;
import com.bms.weddingorganizationcompanysystem.dto.converter.PersonDtoConverter;
import com.bms.weddingorganizationcompanysystem.exception.person.PersonAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.person.PersonListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.person.PersonNotFoundException;
import com.bms.weddingorganizationcompanysystem.helper.Generator;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessLogMessage;
import com.bms.weddingorganizationcompanysystem.helper.message.BusinessMessage;
import com.bms.weddingorganizationcompanysystem.model.Person;
import com.bms.weddingorganizationcompanysystem.repository.PersonRepository;
import com.bms.weddingorganizationcompanysystem.request.person.CreatePersonRequest;
import com.bms.weddingorganizationcompanysystem.request.person.UpdatePersonRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonDtoConverter converter;

    public PersonService(PersonRepository personRepository,
                         PersonDtoConverter converter) {
        this.personRepository = personRepository;
        this.converter = converter;
    }

    public void createPerson(final CreatePersonRequest request) {
        checkIfPersonExists(request.getFirstName(), request.getLastName());

        Person person = Person.builder()
                .personCode(Generator.generateCode())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();

        personRepository.save(person);
        log.info(BusinessLogMessage.Person.PERSON_CREATED + request.getFirstName() + " " + request.getLastName());
    }

    public void updatePerson(final String id, final UpdatePersonRequest request) {
        Person person = findPersonById(id);

        if (!person.getFirstName().equals(request.getFirstName()) || !person.getLastName().equals(request.getLastName())) {
            checkIfPersonExists(request.getFirstName(), request.getLastName());
        }

        person.setFirstName(request.getFirstName());
        person.setLastName(request.getLastName());

        personRepository.save(person);
        log.info(BusinessLogMessage.Person.PERSON_UPDATED + id);
    }

    public void deletePerson(final String id) {
        personRepository.delete(findPersonById(id));
        log.info(BusinessLogMessage.Person.PERSON_DELETED + id);
    }

    public PersonDto findPerson(final String id) {
        log.info(BusinessLogMessage.Person.PERSON_FOUND + id);
        return converter.convert(findPersonById(id));
    }

    public List<PersonDto> findAllPersons() {
        List<Person> persons = personRepository.findAll();

        if (persons.isEmpty()) {
            log.error(BusinessLogMessage.Person.PERSON_LIST_EMPTY);
            throw new PersonListEmptyException(BusinessMessage.Person.PERSON_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Person.PERSON_LISTED);
        return converter.convert(persons);
    }

    protected Person findPersonById(final String id) {
        return personRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Person.PERSON_NOT_FOUND + id);
            throw new PersonNotFoundException(BusinessMessage.Person.PERSON_NOT_FOUND);
        });
    }

    private void checkIfPersonExists(final String firstName, final String lastName) {
        if (personRepository.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName)) {
            log.error(BusinessLogMessage.Person.PERSON_ALREADY_EXISTS + firstName + " " + lastName);
            throw new PersonAlreadyExistException(BusinessMessage.Person.PERSON_ALREADY_EXISTS);
        }
    }
}
