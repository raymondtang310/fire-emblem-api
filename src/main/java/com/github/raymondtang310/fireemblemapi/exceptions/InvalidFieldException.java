package com.github.raymondtang310.fireemblemapi.exceptions;

public class InvalidFieldException extends RuntimeException {
    public InvalidFieldException(String fieldName) {
        super(String.format("'%s' is not a valid field", fieldName));
    }
}
