package com.github.raymondtang310.fireemblemapi.exceptions.handlers;

import com.github.raymondtang310.fireemblemapi.exceptions.InvalidFieldException;
import com.github.raymondtang310.fireemblemapi.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class InvalidFieldExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidFieldException.class)
    public ResponseEntity<ErrorResponse> getResponseEntity(Exception exception, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, "INVALID_FIELD", exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
