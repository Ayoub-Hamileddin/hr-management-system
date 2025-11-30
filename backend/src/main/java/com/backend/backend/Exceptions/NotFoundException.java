package com.backend.backend.Exceptions;

public class NotFoundException extends RuntimeException {
    private final String field;

    public NotFoundException(String field,String message) {
        super(message);
        this.field=field;
    }

    public String getField() {
        return this.field;
    }

}
