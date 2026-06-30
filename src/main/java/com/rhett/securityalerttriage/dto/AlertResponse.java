package com.rhett.securityalerttriage.dto;

import com.rhett.securityalerttriage.model.Alert;
import com.rhett.securityalerttriage.model.Severity;
import com.rhett.securityalerttriage.model.Source;
import com.rhett.securityalerttriage.model.Status;

import java.time.Instant;
import java.util.UUID;

public class AlertResponse {

    private UUID id;
    private String title;
    private String description;
    private Severity severity;
    private Source source;
    private Status status;
    private Instant createdAt;
    private Instant updatedAt;

    public AlertResponse() {
    }

    public AlertResponse(
            UUID id,
            String title,
            String description,
            Severity severity,
            Source source,
            Status status,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.source = source;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static AlertResponse fromAlert(Alert alert) {
        return new AlertResponse(
                alert.getId(),
                alert.getTitle(),
                alert.getDescription(),
                alert.getSeverity(),
                alert.getSource(),
                alert.getStatus(),
                alert.getCreatedAt(),
                alert.getUpdatedAt()
        );
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Source getSource() {
        return source;
    }

    public Status getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}