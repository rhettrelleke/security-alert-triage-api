package com.rhett.securityalerttriage.dto;

import com.rhett.securityalerttriage.model.Severity;
import com.rhett.securityalerttriage.model.Source;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAlertRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be 100 characters or less")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must be 1000 characters or less")
    private String description;

    @NotNull(message = "Severity is required")
    private Severity severity;

    @NotNull(message = "Source is required")
    private Source source;

    public CreateAlertRequest() {
    }

    public CreateAlertRequest(String title, String description, Severity severity, Source source) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.source = source;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}