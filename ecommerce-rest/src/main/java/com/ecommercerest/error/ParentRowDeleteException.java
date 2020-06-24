package com.ecommercerest.error;

import org.springframework.dao.DataIntegrityViolationException;

public class ParentRowDeleteException extends DataIntegrityViolationException {

    public ParentRowDeleteException(String msg) {
        super(msg);
    }
}
