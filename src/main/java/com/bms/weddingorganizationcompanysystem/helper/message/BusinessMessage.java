package com.bms.weddingorganizationcompanysystem.helper.message;

public class BusinessMessage {
    public static final String ILLEGAL_STATE_EXCEPTION = "Utility class, cannot be instantiated";

    private BusinessMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class City {
        private City() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CITY_NOT_FOUND = "City not found, please check the id.";
        public static final String CITY_LIST_EMPTY = "City list is empty. Please add a city.";
        public static final String CITY_ALREADY_EXISTS = "City already exists, please check the name.";
    }

    public static class Country {
        private Country() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String COUNTRY_NOT_FOUND = "Country not found, please check the id.";
        public static final String COUNTRY_LIST_EMPTY = "Country list is empty. Please add a country.";
        public static final String COUNTRY_ALREADY_EXISTS = "Country already exists, please check the name.";
    }

    public static class Employment {
        private Employment() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_NOT_FOUND = "Employment not found, please check the id.";
        public static final String EMPLOYMENT_LIST_EMPTY = "Employment list is empty. Please add a employment.";
        public static final String EMPLOYMENT_ALREADY_EXISTS = "Employment already exists, please check the name.";
    }

    public static class EmploymentInclude {
        private EmploymentInclude() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_INCLUDE_NOT_FOUND = "EmploymentInclude not found, please check the id.";
        public static final String EMPLOYMENT_INCLUDE_LIST_EMPTY = "EmploymentInclude list is empty. Please add a employmentInclude.";
    }

    public static class EmploymentProvider {
        private EmploymentProvider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_PROVIDER_NOT_FOUND = "EmploymentProvider not found, please check the id.";
        public static final String EMPLOYMENT_PROVIDER_LIST_EMPTY = "EmploymentProvider list is empty. Please add a employmentProvider.";
    }

    public static class Event {
        private Event() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EVENT_NOT_FOUND = "Event not found, please check the id.";
        public static final String EVENT_LIST_EMPTY = "Event list is empty. Please add a event.";
    }

    public static class InEvent {
        private InEvent() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String IN_EVENT_NOT_FOUND = "InEvent not found, please check the id.";
        public static final String IN_EVENT_LIST_EMPTY = "InEvent list is empty. Please add a inEvent.";
    }

    public static class Invoice {
        private Invoice() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_NOT_FOUND = "Invoice not found, please check the id.";
        public static final String INVOICE_LIST_EMPTY = "Invoice list is empty. Please add a invoice.";
    }

    public static class InvoiceItem{
        private InvoiceItem() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_ITEM_NOT_FOUND = "InvoiceItem not found, please check the id.";
        public static final String INVOICE_ITEM_LIST_EMPTY = "InvoiceItem list is empty. Please add a invoiceItem.";
    }

    public static class Location{
        private Location() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String LOCATION_NOT_FOUND = "Location not found, please check the id.";
        public static final String LOCATION_LIST_EMPTY = "Location list is empty. Please add a location.";
    }

    public static class Participate{
        private Participate() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PARTICIPATE_NOT_FOUND = "Participate not found, please check the id.";
        public static final String PARTICIPATE_LIST_EMPTY = "Participate list is empty. Please add a participate.";
    }

    public static class Partner{
        private Partner() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PARTNER_NOT_FOUND = "Partner not found, please check the id.";
        public static final String PARTNER_LIST_EMPTY = "Partner list is empty. Please add a partner.";
    }

    public static class Person{
        private Person() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PERSON_NOT_FOUND = "Person not found, please check the id.";
        public static final String PERSON_LIST_EMPTY = "Person list is empty. Please add a person.";
        public static final String PERSON_ALREADY_EXISTS = "Person already exists, please check the name.";
    }

    public static class Product{
        private Product() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_NOT_FOUND = "Product not found, please check the id.";
        public static final String PRODUCT_LIST_EMPTY = "Product list is empty. Please add a product.";
        public static final String PRODUCT_ALREADY_EXISTS = "Product already exists, please check the name.";
    }

    public static class ProductInclude{
        private ProductInclude() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_INCLUDE_NOT_FOUND = "ProductInclude not found, please check the id.";
        public static final String PRODUCT_INCLUDE_LIST_EMPTY = "ProductInclude list is empty. Please add a productInclude.";
    }

    public static class ProductProvider{
        private ProductProvider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_PROVIDER_NOT_FOUND = "ProductProvider not found, please check the id.";
        public static final String PRODUCT_PROVIDER_LIST_EMPTY = "ProductProvider list is empty. Please add a productProvider.";
    }

    public static class Role{
        private Role() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROLE_NOT_FOUND = "Role not found, please check the id.";
        public static final String ROLE_LIST_EMPTY = "Role list is empty. Please add a role.";
        public static final String ROLE_ALREADY_EXISTS = "Role already exists, please check the name.";
    }

    public static class Status{
        private Status() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_NOT_FOUND = "Status not found, please check the id.";
        public static final String STATUS_LIST_EMPTY = "Status list is empty. Please add a status.";
        public static final String STATUS_ALREADY_EXISTS = "Status already exists, please check the name.";
    }

    public static class Wedding{
        private Wedding() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String WEDDING_NOT_FOUND = "Wedding not found, please check the id.";
        public static final String WEDDING_LIST_EMPTY = "Wedding list is empty. Please add a wedding.";
    }
}
