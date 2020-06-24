package com.ecommercerest.error;

public class StorageEmptyFileException extends IllegalArgumentException {

    public StorageEmptyFileException(String s) {
        super(s);
    }

    public StorageEmptyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
