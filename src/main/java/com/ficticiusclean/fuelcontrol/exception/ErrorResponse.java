package com.ficticiusclean.fuelcontrol.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse(int errorCode, String error, String message) {
    public ErrorResponse(HttpStatus status, String message) {
        this(status.value(), status.name(), message);
    }
}
