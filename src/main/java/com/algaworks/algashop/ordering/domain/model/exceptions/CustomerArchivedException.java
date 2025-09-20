package com.algaworks.algashop.ordering.domain.model.exceptions;

public class CustomerArchivedException extends DomainException {
    public CustomerArchivedException() {
        super(ErrorMessages.ERROR_CUSTOMER_ARCHIVED);
    }

    public CustomerArchivedException(String message, Throwable cause) {
        super(ErrorMessages.ERROR_CUSTOMER_ARCHIVED, cause);
    }
}
