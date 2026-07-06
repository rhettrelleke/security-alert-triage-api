package com.rhett.securityalerttriage.service;

import com.rhett.securityalerttriage.dto.CreateAlertRequest;
import com.rhett.securityalerttriage.exception.AlertNotFoundException;
import com.rhett.securityalerttriage.model.Alert;
import com.rhett.securityalerttriage.model.Severity;
import com.rhett.securityalerttriage.model.Source;
import com.rhett.securityalerttriage.model.Status;
import com.rhett.securityalerttriage.repository.AlertRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AlertServiceTest {

    private AlertService alertService;

    @BeforeEach
    void setUp() {
        AlertRepository alertRepository = new AlertRepository();
        alertService = new AlertService(alertRepository);
    }

    @Test
    void createAlertAssignsServerOwnedFields() {
        CreateAlertRequest request = new CreateAlertRequest(
                "Suspicious login activity",
                "Multiple failed login attempts detected from an unfamiliar location.",
                Severity.HIGH,
                Source.CYBER
        );

        Alert alert = alertService.createAlert(request);

        assertNotNull(alert.getId());
        assertEquals("Suspicious login activity", alert.getTitle());
        assertEquals("Multiple failed login attempts detected from an unfamiliar location.", alert.getDescription());
        assertEquals(Severity.HIGH, alert.getSeverity());
        assertEquals(Source.CYBER, alert.getSource());
        assertEquals(Status.OPEN, alert.getStatus());
        assertNotNull(alert.getCreatedAt());
        assertNotNull(alert.getUpdatedAt());
        assertEquals(alert.getCreatedAt(), alert.getUpdatedAt());
    }

    @Test
    void getAlertByIdThrowsWhenAlertDoesNotExist() {
        UUID missingId = UUID.randomUUID();

        assertThrows(
                AlertNotFoundException.class,
                () -> alertService.getAlertById(missingId)
        );
    }

    @Test
    void updateAlertStatusChangesStatusAndUpdatedAt() throws InterruptedException {
        CreateAlertRequest request = new CreateAlertRequest(
                "Door forced open",
                "Physical access control system reported a forced door event.",
                Severity.CRITICAL,
                Source.PHYSICAL
        );

        Alert createdAlert = alertService.createAlert(request);

        Thread.sleep(1);

        Alert updatedAlert = alertService.updateAlertStatus(
                createdAlert.getId(),
                Status.IN_PROGRESS
        );

        assertEquals(Status.IN_PROGRESS, updatedAlert.getStatus());
        assertTrue(updatedAlert.getUpdatedAt().isAfter(updatedAlert.getCreatedAt()));
    }
}