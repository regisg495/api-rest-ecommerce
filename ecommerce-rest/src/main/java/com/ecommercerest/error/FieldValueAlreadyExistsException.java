package com.ecommercerest.error;

import org.springframework.dao.DataIntegrityViolationException;

public class FieldValueAlreadyExistsException extends DataIntegrityViolationException {

    public FieldValueAlreadyExistsException(String msg) {
        super(msg);
    }
}
