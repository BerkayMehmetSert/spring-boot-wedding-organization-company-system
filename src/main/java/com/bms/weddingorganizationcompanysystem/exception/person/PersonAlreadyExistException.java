package com.bms.weddingorganizationcompanysystem.exception.person;

public class PersonAlreadyExistException extends RuntimeException {
    public PersonAlreadyExistException(String message) {
        super(message);
    }
}
