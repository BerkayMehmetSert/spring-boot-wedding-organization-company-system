package com.bms.weddingorganizationcompanysystem.dto.converter;

import com.bms.weddingorganizationcompanysystem.dto.PersonDto;
import com.bms.weddingorganizationcompanysystem.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDtoConverter {
    private final PersonParticipateDtoConverter personParticipateDtoConverter;

    public PersonDtoConverter(PersonParticipateDtoConverter personParticipateDtoConverter) {
        this.personParticipateDtoConverter = personParticipateDtoConverter;
    }

    public PersonDto convert(Person from) {
        return new PersonDto(
                from.getId(),
                from.getPersonCode(),
                from.getFirstName(),
                from.getLastName(),
                from.getParticipates() != null ? personParticipateDtoConverter.convert(from.getParticipates()) : null
        );
    }

    public List<PersonDto> convert(List<Person> from) {
        return from.stream().map(this::convert).toList();
    }
}
