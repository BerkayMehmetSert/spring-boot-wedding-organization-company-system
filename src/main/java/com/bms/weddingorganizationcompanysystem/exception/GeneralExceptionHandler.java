package com.bms.weddingorganizationcompanysystem.exception;

import com.bms.weddingorganizationcompanysystem.exception.city.CityAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.city.CityListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.city.CityNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.country.CountryAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.country.CountryListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.country.CountryNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.employment.EmploymentAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.employment.EmploymentListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.employment.EmploymentNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.employmentinclude.EmploymentIncludeListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.employmentinclude.EmploymentIncludeNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.employmentprovider.EmploymentProviderListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.employmentprovider.EmploymentProviderNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.event.EventListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.event.EventNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.inevent.InEventListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.inevent.InEventNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.invoice.InvoiceListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.invoice.InvoiceNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.invoiceıtem.InvoiceItemListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.invoiceıtem.InvoiceItemNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.location.LocationListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.location.LocationNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.participate.ParticipateListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.participate.ParticipateNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.partner.PartnerListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.partner.PartnerNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.person.PersonAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.person.PersonListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.person.PersonNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.product.ProductAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.product.ProductListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.product.ProductNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.productinclude.ProductIncludeListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.productinclude.ProductIncludeNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.productprovider.ProductProviderListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.productprovider.ProductProviderNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.role.RoleAlreadyExistException;
import com.bms.weddingorganizationcompanysystem.exception.role.RoleListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.role.RoleNotFoundException;
import com.bms.weddingorganizationcompanysystem.exception.wedding.WeddingListEmptyException;
import com.bms.weddingorganizationcompanysystem.exception.wedding.WeddingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CityAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleCityAlreadyExistException(CityAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(CityListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCityListEmptyException(CityListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCityNotFoundException(CityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CountryAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleCountryAlreadyExistException(CountryAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(CountryListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCountryListEmptyException(CountryListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCountryNotFoundException(CountryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EmploymentAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleEmploymentAlreadyExistException(EmploymentAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(EmploymentListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEmploymentListEmptyException(EmploymentListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EmploymentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEmploymentNotFoundException(EmploymentNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EmploymentIncludeListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEmploymentIncludeListEmptyException(EmploymentIncludeListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EmploymentIncludeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEmploymentIncludeNotFoundException(EmploymentIncludeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EmploymentProviderListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEmploymentProviderListEmptyException(EmploymentProviderListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EmploymentProviderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEmploymentProviderNotFoundException(EmploymentProviderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EventListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEventListEmptyException(EventListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(EventNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleEventNotFoundException(EventNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InEventListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleInEventListEmptyException(InEventListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InEventNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleInEventNotFoundException(InEventNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvoiceListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleInvoiceListEmptyException(InvoiceListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvoiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleInvoiceNotFoundException(InvoiceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvoiceItemListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleInvoiceItemListEmptyException(InvoiceItemListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InvoiceItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleInvoiceItemNotFoundException(InvoiceItemNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(LocationListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleLocationListEmptyException(LocationListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleLocationNotFoundException(LocationNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ParticipateListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleParticipateListEmptyException(ParticipateListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ParticipateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleParticipateNotFoundException(ParticipateNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PartnerListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePartnerListEmptyException(PartnerListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PartnerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePartnerNotFoundException(PartnerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PersonAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handlePersonAlreadyExistException(PersonAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(PersonListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePersonListEmptyException(PersonListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleProductAlreadyExistException(ProductAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ProductListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleProductListEmptyException(ProductListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductIncludeListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleProductIncludeListEmptyException(ProductIncludeListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductIncludeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleProductIncludeNotFoundException(ProductIncludeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductProviderListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleProductProviderListEmptyException(ProductProviderListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ProductProviderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleProductProviderNotFoundException(ProductProviderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RoleAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> handleRoleAlreadyExistException(RoleAlreadyExistException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(RoleListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleRoleListEmptyException(RoleListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleRoleNotFoundException(RoleNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(WeddingListEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleWeddingListEmptyException(WeddingListEmptyException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(WeddingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleWeddingNotFoundException(WeddingNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
