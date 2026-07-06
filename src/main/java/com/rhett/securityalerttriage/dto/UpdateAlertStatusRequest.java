package com.rhett.securityalerttriage.dto;

import com.rhett.securityalerttriage.model.Status;
import jakarta.validation.constraints.NotNull;

public class UpdateAlertStatusRequest {

    @NotNull(message = "Status is required")
    private Status status;

    public UpdateAlertStatusRequest() {
    }

    public UpdateAlertStatusRequest(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}