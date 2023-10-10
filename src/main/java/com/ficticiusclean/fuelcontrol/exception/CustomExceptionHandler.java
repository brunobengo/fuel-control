package com.ficticiusclean.fuelcontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CarNotExistException.class)
    public final ResponseEntity<ErrorResponse> handleCarNotExistException(CarNotExistException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
