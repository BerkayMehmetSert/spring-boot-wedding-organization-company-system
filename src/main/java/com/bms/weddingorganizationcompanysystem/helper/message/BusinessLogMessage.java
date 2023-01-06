package com.bms.weddingorganizationcompanysystem.helper.message;

public class BusinessLogMessage {

    private BusinessLogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class City {
        private City() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CITY_NOT_FOUND = "City not found, please check the id.";
        public static final String CITY_LIST_EMPTY = "City list is empty. Please add a city.";
        public static final String CITY_ALREADY_EXISTS = "City already exists, please check the name.";
        public static final String CITY_CREATED = "City created successfully. City name: ";
        public static final String CITY_UPDATED = "City updated successfully. City id: ";
        public static final String CITY_DELETED = "City deleted successfully. City id: ";
        public static final String CITY_LISTED = "City listed successfully.";
        public static final String CITY_FOUND = "City found successfully. City id: ";
    }

    public static class Country {
        private Country() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String COUNTRY_NOT_FOUND = "Country not found, please check the id.";
        public static final String COUNTRY_LIST_EMPTY = "Country list is empty. Please add a country.";
        public static final String COUNTRY_ALREADY_EXISTS = "Country already exists, please check the name.";
        public static final String COUNTRY_CREATED = "Country created successfully. Country name: ";
        public static final String COUNTRY_UPDATED = "Country updated successfully. Country id: ";
        public static final String COUNTRY_DELETED = "Country deleted successfully. Country id: ";
        public static final String COUNTRY_LISTED = "Country listed successfully.";
        public static final String COUNTRY_FOUND = "Country found successfully. Country id: ";
    }

    public static class Employment {
        private Employment() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_NOT_FOUND = "Employment not found, please check the id.";
        public static final String EMPLOYMENT_LIST_EMPTY = "Employment list is empty. Please add a employment.";
        public static final String EMPLOYMENT_ALREADY_EXISTS = "Employment already exists, please check the name.";
        public static final String EMPLOYMENT_CREATED = "Employment created successfully. Employment name: ";
        public static final String EMPLOYMENT_UPDATED = "Employment updated successfully. Employment id: ";
        public static final String EMPLOYMENT_DELETED = "Employment deleted successfully. Employment id: ";
        public static final String EMPLOYMENT_LISTED = "Employment listed successfully.";
        public static final String EMPLOYMENT_FOUND = "Employment found successfully. Employment id: ";
    }

    public static class EmploymentInclude {
        private EmploymentInclude() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_INCLUDE_NOT_FOUND = "EmploymentInclude not found, please check the id.";
        public static final String EMPLOYMENT_INCLUDE_LIST_EMPTY = "EmploymentInclude list is empty. Please add a employmentInclude.";
        public static final String EMPLOYMENT_INCLUDE_CREATED = "EmploymentInclude created successfully. EmploymentInclude name: ";
        public static final String EMPLOYMENT_INCLUDE__UPDATED = "EmploymentInclude updated successfully. EmploymentInclude id: ";
        public static final String EMPLOYMENT_INCLUDE__DELETED = "EmploymentInclude deleted successfully. EmploymentInclude id: ";
        public static final String EMPLOYMENT_INCLUDE__LISTED = "EmploymentInclude listed successfully.";
        public static final String EMPLOYMENT_INCLUDE__FOUND = "EmploymentInclude found successfully. EmploymentInclude id: ";
    }

    public static class EmploymentProvider {
        private EmploymentProvider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_PROVIDER_NOT_FOUND = "EmploymentProvider not found, please check the id.";
        public static final String EMPLOYMENT_PROVIDER_LIST_EMPTY = "EmploymentProvider list is empty. Please add a employmentProvider.";
        public static final String EMPLOYMENT_PROVIDER_CREATED = "EmploymentProvider created successfully. EmploymentProvider name: ";
        public static final String EMPLOYMENT_PROVIDER_UPDATED = "EmploymentProvider updated successfully. EmploymentProvider id: ";
        public static final String EMPLOYMENT_PROVIDER_DELETED = "EmploymentProvider deleted successfully. EmploymentProvider id: ";
        public static final String EMPLOYMENT_PROVIDER_LISTED = "EmploymentProvider listed successfully.";
        public static final String EMPLOYMENT_PROVIDER_FOUND = "EmploymentProvider found successfully. EmploymentProvider id: ";
    }

    public static class Event {
        private Event() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EVENT_NOT_FOUND = "Event not found, please check the id.";
        public static final String EVENT_LIST_EMPTY = "Event list is empty. Please add a event.";
        public static final String EVENT_CREATED = "Event created successfully. Event name: ";
        public static final String EVENT_UPDATED = "Event updated successfully. Event id: ";
        public static final String EVENT_DELETED = "Event deleted successfully. Event id: ";
        public static final String EVENT_LISTED = "Event listed successfully.";
        public static final String EVENT_FOUND = "Event found successfully. Event id: ";
    }

    public static class InEvent {
        private InEvent() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String IN_EVENT_NOT_FOUND = "InEvent not found, please check the id.";
        public static final String IN_EVENT_LIST_EMPTY = "InEvent list is empty. Please add a inEvent.";
        public static final String IN_EVENT_CREATED = "InEvent created successfully. InEvent name: ";
        public static final String IN_EVENT_UPDATED = "InEvent updated successfully. InEvent id: ";
        public static final String IN_EVENT_DELETED = "InEvent deleted successfully. InEvent id: ";
        public static final String IN_EVENT_LISTED = "InEvent listed successfully.";
        public static final String IN_EVENT_FOUND = "InEvent found successfully. InEvent id: ";
    }

    public static class Invoice {
        private Invoice() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_NOT_FOUND = "Invoice not found, please check the id.";
        public static final String INVOICE_LIST_EMPTY = "Invoice list is empty. Please add a invoice.";
        public static final String INVOICE_CREATED = "Invoice created successfully. Invoice name: ";
        public static final String INVOICE_UPDATED = "Invoice updated successfully. Invoice id: ";
        public static final String INVOICE_DELETED = "Invoice deleted successfully. Invoice id: ";
        public static final String INVOICE_LISTED = "Invoice listed successfully.";
        public static final String INVOICE_FOUND = "Invoice found successfully. Invoice id: ";
    }

    public static class InvoiceItem {
        private InvoiceItem() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_ITEM_NOT_FOUND = "InvoiceItem not found, please check the id.";
        public static final String INVOICE_ITEM_LIST_EMPTY = "InvoiceItem list is empty. Please add a invoiceItem.";
        public static final String INVOICE_ITEM_CREATED = "InvoiceItem created successfully. InvoiceItem name: ";
        public static final String INVOICE_ITEM_UPDATED = "InvoiceItem updated successfully. InvoiceItem id: ";
        public static final String INVOICE_ITEM_DELETED = "InvoiceItem deleted successfully. InvoiceItem id: ";
        public static final String INVOICE_ITEM_LISTED = "InvoiceItem listed successfully.";
        public static final String INVOICE_ITEM_FOUND = "InvoiceItem found successfully. InvoiceItem id: ";
    }

    public static class Location {
        private Location() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String LOCATION_NOT_FOUND = "Location not found, please check the id.";
        public static final String LOCATION_LIST_EMPTY = "Location list is empty. Please add a location.";
        public static final String LOCATION_CREATED = "Location created successfully. Location name: ";
        public static final String LOCATION_UPDATED = "Location updated successfully. Location id: ";
        public static final String LOCATION_DELETED = "Location deleted successfully. Location id: ";
        public static final String LOCATION_LISTED = "Location listed successfully.";
        public static final String LOCATION_FOUND = "Location found successfully. Location id: ";
    }

    public static class Participate {
        private Participate() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PARTICIPATE_NOT_FOUND = "Participate not found, please check the id.";
        public static final String PARTICIPATE_LIST_EMPTY = "Participate list is empty. Please add a participate.";
        public static final String PARTICIPATE_CREATED = "Participate created successfully. Participate name: ";
        public static final String PARTICIPATE_UPDATED = "Participate updated successfully. Participate id: ";
        public static final String PARTICIPATE_DELETED = "Participate deleted successfully. Participate id: ";
        public static final String PARTICIPATE_LISTED = "Participate listed successfully.";
        public static final String PARTICIPATE_FOUND = "Participate found successfully. Participate id: ";
    }

    public static class Partner {
        private Partner() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PARTNER_NOT_FOUND = "Partner not found, please check the id.";
        public static final String PARTNER_LIST_EMPTY = "Partner list is empty. Please add a partner.";
        public static final String PARTNER_CREATED = "Partner created successfully. Partner name: ";
        public static final String PARTNER_UPDATED = "Partner updated successfully. Partner id: ";
        public static final String PARTNER_DELETED = "Partner deleted successfully. Partner id: ";
        public static final String PARTNER_LISTED = "Partner listed successfully.";
        public static final String PARTNER_FOUND = "Partner found successfully. Partner id: ";
    }

    public static class Person {
        private Person() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PERSON_NOT_FOUND = "Person not found, please check the id.";
        public static final String PERSON_LIST_EMPTY = "Person list is empty. Please add a person.";
        public static final String PERSON_ALREADY_EXISTS = "Person already exists, please check the name.";
        public static final String PERSON_CREATED = "Person created successfully. Person name: ";
        public static final String PERSON_UPDATED = "Person updated successfully. Person id: ";
        public static final String PERSON_DELETED = "Person deleted successfully. Person id: ";
        public static final String PERSON_LISTED = "Person listed successfully.";
        public static final String PERSON_FOUND = "Person found successfully. Person id: ";
    }

    public static class Product {
        private Product() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_NOT_FOUND = "Product not found, please check the id.";
        public static final String PRODUCT_LIST_EMPTY = "Product list is empty. Please add a product.";
        public static final String PRODUCT_ALREADY_EXISTS = "Product already exists, please check the name.";
        public static final String PRODUCT_CREATED = "Product created successfully. Product name: ";
        public static final String PRODUCT_UPDATED = "Product updated successfully. Product id: ";
        public static final String PRODUCT_DELETED = "Product deleted successfully. Product id: ";
        public static final String PRODUCT_LISTED = "Product listed successfully.";
        public static final String PRODUCT_FOUND = "Product found successfully. Product id: ";
    }

    public static class ProductInclude {
        private ProductInclude() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_INCLUDE_NOT_FOUND = "ProductInclude not found, please check the id.";
        public static final String PRODUCT_INCLUDE_LIST_EMPTY = "ProductInclude list is empty. Please add a productInclude.";
        public static final String PRODUCT_INCLUDE_CREATED = "ProductInclude created successfully. ProductInclude name: ";
        public static final String PRODUCT_INCLUDE_UPDATED = "ProductInclude updated successfully. ProductInclude id: ";
        public static final String PRODUCT_INCLUDE_DELETED = "ProductInclude deleted successfully. ProductInclude id: ";
        public static final String PRODUCT_INCLUDE_LISTED = "ProductInclude listed successfully.";
        public static final String PRODUCT_INCLUDE_FOUND = "ProductInclude found successfully. ProductInclude id: ";
    }

    public static class ProductProvider {
        private ProductProvider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_PROVIDER_NOT_FOUND = "ProductProvider not found, please check the id.";
        public static final String PRODUCT_PROVIDER_LIST_EMPTY = "ProductProvider list is empty. Please add a productProvider.";
        public static final String PRODUCT_PROVIDER_CREATED = "ProductProvider created successfully. ProductProvider name: ";
        public static final String PRODUCT_PROVIDER_UPDATED = "ProductProvider updated successfully. ProductProvider id: ";
        public static final String PRODUCT_PROVIDER_DELETED = "ProductProvider deleted successfully. ProductProvider id: ";
        public static final String PRODUCT_PROVIDER_LISTED = "ProductProvider listed successfully.";
        public static final String PRODUCT_PROVIDER_FOUND = "ProductProvider found successfully. ProductProvider id: ";
    }

    public static class Role {
        private Role() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROLE_NOT_FOUND = "Role not found, please check the id.";
        public static final String ROLE_LIST_EMPTY = "Role list is empty. Please add a role.";
        public static final String ROLE_ALREADY_EXISTS = "Role already exists, please check the name.";
        public static final String ROLE_CREATED = "Role created successfully. Role name: ";
        public static final String ROLE_UPDATED = "Role updated successfully. Role id: ";
        public static final String ROLE_DELETED = "Role deleted successfully. Role id: ";
        public static final String ROLE_LISTED = "Role listed successfully.";
        public static final String ROLE_FOUND = "Role found successfully. Role id: ";
    }

    public static class Status {
        private Status() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_NOT_FOUND = "Status not found, please check the id.";
        public static final String STATUS_LIST_EMPTY = "Status list is empty. Please add a status.";
        public static final String STATUS_ALREADY_EXISTS = "Status already exists, please check the name.";
        public static final String STATUS_CREATED = "Status created successfully. Status name: ";
        public static final String STATUS_UPDATED = "Status updated successfully. Status id: ";
        public static final String STATUS_DELETED = "Status deleted successfully. Status id: ";
        public static final String STATUS_LISTED = "Status listed successfully.";
        public static final String STATUS_FOUND = "Status found successfully. Status id: ";
    }

    public static class Wedding {
        private Wedding() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String WEDDING_NOT_FOUND = "Wedding not found, please check the id.";
        public static final String WEDDING_LIST_EMPTY = "Wedding list is empty. Please add a wedding.";
        public static final String WEDDING_CREATED = "Wedding created successfully. Wedding name: ";
        public static final String WEDDING_UPDATED = "Wedding updated successfully. Wedding id: ";
        public static final String WEDDING_DELETED = "Wedding deleted successfully. Wedding id: ";
        public static final String WEDDING_LISTED = "Wedding listed successfully.";
        public static final String WEDDING_FOUND = "Wedding found successfully. Wedding id: ";
    }
}
