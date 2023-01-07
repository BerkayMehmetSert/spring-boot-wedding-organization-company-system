package com.bms.weddingorganizationcompanysystem.helper.message;

public class ControllerLogMessage {

    private ControllerLogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class City {
        private City() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CITY_CREATED = "City Controller: City created successfully. City name: ";
        public static final String CITY_UPDATED = "City Controller: City updated successfully. City id: ";
        public static final String CITY_DELETED = "City Controller: City deleted successfully. City id: ";
        public static final String CITY_LISTED = "City Controller: City listed successfully.";
        public static final String CITY_FOUND = "City Controller: City found successfully. City id: ";
    }

    public static class Country {
        private Country() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String COUNTRY_CREATED = "Country Controller: Country created successfully. Country name: ";
        public static final String COUNTRY_UPDATED = "Country Controller: Country updated successfully. Country id: ";
        public static final String COUNTRY_DELETED = "Country Controller: Country deleted successfully. Country id: ";
        public static final String COUNTRY_LISTED = "Country Controller: Country listed successfully.";
        public static final String COUNTRY_FOUND = "Country Controller: Country found successfully. Country id: ";
    }

    public static class Employment {
        private Employment() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_CREATED = "Employment Controller: Employment created successfully. Employment name: ";
        public static final String EMPLOYMENT_UPDATED = "Employment Controller: Employment updated successfully. Employment id: ";
        public static final String EMPLOYMENT_DELETED = "Employment Controller: Employment deleted successfully. Employment id: ";
        public static final String EMPLOYMENT_LISTED = "Employment Controller: Employment listed successfully.";
        public static final String EMPLOYMENT_FOUND = "Employment Controller: Employment found successfully. Employment id: ";
        public static final String EMPLOYMENT_PDF_CREATED = "Employment Controller: Employment pdf created successfully. Employment id: ";
    }

    public static class EmploymentInclude {
        private EmploymentInclude() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_INCLUDE_CREATED = "EmploymentInclude Controller: EmploymentInclude created successfully. EmploymentInclude name: ";
        public static final String EMPLOYMENT_INCLUDE_UPDATED = "EmploymentInclude Controller: EmploymentInclude updated successfully. EmploymentInclude id: ";
        public static final String EMPLOYMENT_INCLUDE_DELETED = "EmploymentInclude Controller: EmploymentInclude deleted successfully. EmploymentInclude id: ";
        public static final String EMPLOYMENT_INCLUDE_LISTED = "EmploymentInclude Controller: EmploymentInclude listed successfully.";
        public static final String EMPLOYMENT_INCLUDE_FOUND = "EmploymentInclude Controller: EmploymentInclude found successfully. EmploymentInclude id: ";
    }

    public static class EmploymentProvider {
        private EmploymentProvider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMPLOYMENT_PROVIDER_CREATED = "EmploymentProvider Controller: EmploymentProvider created successfully. EmploymentProvider name: ";
        public static final String EMPLOYMENT_PROVIDER_UPDATED = "EmploymentProvider Controller: EmploymentProvider updated successfully. EmploymentProvider id: ";
        public static final String EMPLOYMENT_PROVIDER_DELETED = "EmploymentProvider Controller: EmploymentProvider deleted successfully. EmploymentProvider id: ";
        public static final String EMPLOYMENT_PROVIDER_LISTED = "EmploymentProvider Controller: EmploymentProvider listed successfully.";
        public static final String EMPLOYMENT_PROVIDER_FOUND = "EmploymentProvider Controller: EmploymentProvider found successfully. EmploymentProvider id: ";
    }

    public static class Event {
        public static final String EVENT_COMPLETED = "Event Controller: Event completed successfully. Event id: ";

        private Event() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EVENT_CREATED = "Event Controller: Event created successfully. Event name: ";
        public static final String EVENT_UPDATED = "Event Controller: Event updated successfully. Event id: ";
        public static final String EVENT_DELETED = "Event Controller: Event deleted successfully. Event id: ";
        public static final String EVENT_LISTED = "Event Controller: Event listed successfully.";
        public static final String EVENT_FOUND = "Event Controller: Event found successfully. Event id: ";
    }

    public static class InEvent {
        private InEvent() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String IN_EVENT_CREATED = "InEvent Controller: InEvent created successfully. InEvent name: ";
        public static final String IN_EVENT_UPDATED = "InEvent Controller: InEvent updated successfully. InEvent id: ";
        public static final String IN_EVENT_DELETED = "InEvent Controller: InEvent deleted successfully. InEvent id: ";
        public static final String IN_EVENT_LISTED = "InEvent Controller: InEvent listed successfully.";
        public static final String IN_EVENT_FOUND = "InEvent Controller: InEvent found successfully. InEvent id: ";
    }

    public static class Invoice {
        public static final String INVOICE_PDF_CREATED = "Invoice Controller: Invoice pdf created successfully. Invoice id: ";
        public static final String INVOICE_PAID = "Invoice Controller: Invoice paid successfully. Invoice id: ";

        private Invoice() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_CREATED = "Invoice Controller: Invoice created successfully. Invoice name: ";
        public static final String INVOICE_UPDATED = "Invoice Controller: Invoice updated successfully. Invoice id: ";
        public static final String INVOICE_DELETED = "Invoice Controller: Invoice deleted successfully. Invoice id: ";
        public static final String INVOICE_LISTED = "Invoice Controller: Invoice listed successfully.";
        public static final String INVOICE_FOUND = "Invoice Controller: Invoice found successfully. Invoice id: ";
    }

    public static class InvoiceItem {
        private InvoiceItem() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String INVOICE_ITEM_CREATED = "InvoiceItem Controller: InvoiceItem created successfully. InvoiceItem name: ";
        public static final String INVOICE_ITEM_UPDATED = "InvoiceItem Controller: InvoiceItem updated successfully. InvoiceItem id: ";
        public static final String INVOICE_ITEM_DELETED = "InvoiceItem Controller: InvoiceItem deleted successfully. InvoiceItem id: ";
        public static final String INVOICE_ITEM_LISTED = "InvoiceItem Controller: InvoiceItem listed successfully.";
        public static final String INVOICE_ITEM_FOUND = "InvoiceItem Controller: InvoiceItem found successfully. InvoiceItem id: ";
    }

    public static class Location {
        private Location() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String LOCATION_CREATED = "Location Controller: Location created successfully. Location name: ";
        public static final String LOCATION_UPDATED = "Location Controller: Location updated successfully. Location id: ";
        public static final String LOCATION_DELETED = "Location Controller: Location deleted successfully. Location id: ";
        public static final String LOCATION_LISTED = "Location Controller: Location listed successfully.";
        public static final String LOCATION_FOUND = "Location Controller: Location found successfully. Location id: ";
    }

    public static class Participate {
        private Participate() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PARTICIPATE_CREATED = "Participate Controller: Participate created successfully. Participate name: ";
        public static final String PARTICIPATE_UPDATED = "Participate Controller: Participate updated successfully. Participate id: ";
        public static final String PARTICIPATE_DELETED = "Participate Controller: Participate deleted successfully. Participate id: ";
        public static final String PARTICIPATE_LISTED = "Participate Controller: Participate listed successfully.";
        public static final String PARTICIPATE_FOUND = "Participate Controller: Participate found successfully. Participate id: ";
    }

    public static class Partner {
        private Partner() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PARTNER_CREATED = "Partner Controller: Partner created successfully. Partner name: ";
        public static final String PARTNER_UPDATED = "Partner Controller: Partner updated successfully. Partner id: ";
        public static final String PARTNER_DELETED = "Partner Controller: Partner deleted successfully. Partner id: ";
        public static final String PARTNER_LISTED = "Partner Controller: Partner listed successfully.";
        public static final String PARTNER_FOUND = "Partner Controller: Partner found successfully. Partner id: ";
    }

    public static class Person {
        private Person() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PERSON_CREATED = "Person Controller: Person created successfully. Person name: ";
        public static final String PERSON_UPDATED = "Person Controller: Person updated successfully. Person id: ";
        public static final String PERSON_DELETED = "Person Controller: Person deleted successfully. Person id: ";
        public static final String PERSON_LISTED = "Person Controller: Person listed successfully.";
        public static final String PERSON_FOUND = "Person Controller: Person found successfully. Person id: ";
    }

    public static class Product {
        private Product() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_CREATED = "Product Controller: Product created successfully. Product name: ";
        public static final String PRODUCT_UPDATED = "Product Controller: Product updated successfully. Product id: ";
        public static final String PRODUCT_DELETED = "Product Controller: Product deleted successfully. Product id: ";
        public static final String PRODUCT_LISTED = "Product Controller: Product listed successfully.";
        public static final String PRODUCT_FOUND = "Product Controller: Product found successfully. Product id: ";
    }

    public static class ProductInclude {
        private ProductInclude() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_INCLUDE_CREATED = "ProductInclude Controller: ProductInclude created successfully. ProductInclude name: ";
        public static final String PRODUCT_INCLUDE_UPDATED = "ProductInclude Controller: ProductInclude updated successfully. ProductInclude id: ";
        public static final String PRODUCT_INCLUDE_DELETED = "ProductInclude Controller: ProductInclude deleted successfully. ProductInclude id: ";
        public static final String PRODUCT_INCLUDE_LISTED = "ProductInclude Controller: ProductInclude listed successfully.";
        public static final String PRODUCT_INCLUDE_FOUND = "ProductInclude Controller: ProductInclude found successfully. ProductInclude id: ";
    }

    public static class ProductProvider {
        private ProductProvider() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PRODUCT_PROVIDER_CREATED = "ProductProvider Controller: ProductProvider created successfully. ProductProvider name: ";
        public static final String PRODUCT_PROVIDER_UPDATED = "ProductProvider Controller: ProductProvider updated successfully. ProductProvider id: ";
        public static final String PRODUCT_PROVIDER_DELETED = "ProductProvider Controller: ProductProvider deleted successfully. ProductProvider id: ";
        public static final String PRODUCT_PROVIDER_LISTED = "ProductProvider Controller: ProductProvider listed successfully.";
        public static final String PRODUCT_PROVIDER_FOUND = "ProductProvider Controller: ProductProvider found successfully. ProductProvider id: ";
    }

    public static class Role {
        private Role() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ROLE_CREATED = "Role Controller: Role created successfully. Role name: ";
        public static final String ROLE_UPDATED = "Role Controller: Role updated successfully. Role id: ";
        public static final String ROLE_DELETED = "Role Controller: Role deleted successfully. Role id: ";
        public static final String ROLE_LISTED = "Role Controller: Role listed successfully.";
        public static final String ROLE_FOUND = "Role Controller: Role found successfully. Role id: ";
    }

    public static class Status {
        public static final String STATUS_COMPLETED = "Status Controller: Status completed successfully. Status id: ";

        private Status() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String STATUS_CREATED = "Status Controller: Status created successfully. Status name: ";
        public static final String STATUS_UPDATED = "Status Controller: Status updated successfully. Status id: ";
        public static final String STATUS_DELETED = "Status Controller: Status deleted successfully. Status id: ";
        public static final String STATUS_LISTED = "Status Controller: Status listed successfully.";
        public static final String STATUS_FOUND = "Status Controller: Status found successfully. Status id: ";
    }

    public static class Wedding {
        public static final String WEDDING_COMPLETED = "Wedding Controller: Wedding completed successfully. Wedding id: ";

        private Wedding() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String WEDDING_CREATED = "Wedding Controller: Wedding created successfully.";
        public static final String WEDDING_UPDATED = "Wedding Controller: Wedding updated successfully. Wedding id: ";
        public static final String WEDDING_DELETED = "Wedding Controller: Wedding deleted successfully. Wedding id: ";
        public static final String WEDDING_LISTED = "Wedding Controller: Wedding listed successfully.";
        public static final String WEDDING_FOUND = "Wedding Controller: Wedding found successfully. Wedding id: ";
    }
}
