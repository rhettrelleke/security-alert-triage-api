package com.rhett.securityalerttriage.service;

import com.rhett.securityalerttriage.dto.CreateAlertRequest;
import com.rhett.securityalerttriage.model.Alert;
import com.rhett.securityalerttriage.model.Status;
import com.rhett.securityalerttriage.repository.AlertRepository;
import org.springframework.stereotype.Service;
import com.rhett.securityalerttriage.exception.AlertNotFoundException;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class AlertService {

    private final AlertRepository alertRepository;

    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public Alert createAlert(CreateAlertRequest request) {
        Instant now = Instant.now();

        Alert alert = new Alert(
                UUID.randomUUID(),
                request.getTitle(),
                request.getDescription(),
                request.getSeverity(),
                request.getSource(),
                Status.OPEN,
                now,
                now
        );

        return alertRepository.save(alert);
    }

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public Alert getAlertById(UUID id) {
        return alertRepository.findById(id)
                .orElseThrow(() -> new AlertNotFoundException(id));
    }
}