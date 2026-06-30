package com.rhett.securityalerttriage.exception;

import java.util.UUID;

public class AlertNotFoundException extends RuntimeException {

    public AlertNotFoundException(UUID id) {
        super("Alert not found with id: " + id);
    }
}