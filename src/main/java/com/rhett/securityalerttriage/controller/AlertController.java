package com.rhett.securityalerttriage.controller;

import com.rhett.securityalerttriage.dto.AlertResponse;
import com.rhett.securityalerttriage.dto.CreateAlertRequest;
import com.rhett.securityalerttriage.service.AlertService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlertResponse createAlert(@Valid @RequestBody CreateAlertRequest request) {
        return AlertResponse.fromAlert(alertService.createAlert(request));
    }

    @GetMapping
    public List<AlertResponse> getAllAlerts() {
        return alertService.getAllAlerts()
                .stream()
                .map(AlertResponse::fromAlert)
                .toList();
    }

    @GetMapping("/{id}")
    public AlertResponse getAlertById(@PathVariable UUID id) {
        return AlertResponse.fromAlert(alertService.getAlertById(id));
    }
}