# Security Alert Triage API

A small Spring Boot REST API for creating, viewing, and updating security alerts.

This project was built as a focused Java/Spring Boot interview preparation project. The goal is to demonstrate a clean REST API structure with controller, service, repository, DTO, validation, exception handling, Maven, Git, and basic event-driven design thinking.

## Project Overview

The API models security alerts that may come from cyber, physical, or system sources.

Each alert includes:

- `id`
- `title`
- `description`
- `severity`
- `source`
- `status`
- `createdAt`
- `updatedAt`

Supported alert severities:

- `LOW`
- `MEDIUM`
- `HIGH`
- `CRITICAL`

Supported alert sources:

- `CYBER`
- `PHYSICAL`
- `SYSTEM`

Supported alert statuses:

- `OPEN`
- `IN_PROGRESS`
- `RESOLVED`

## Tech Stack

- Java 17
- Spring Boot 3.5
- Maven
- Spring Web
- Jakarta Validation
- JUnit / Spring Boot Test

## Project Structure

```text
src/main/java/com/rhett/securityalerttriage
├── controller   # REST endpoints
├── dto          # Request and response objects
├── event        # Event publishing abstraction
├── exception    # Custom exceptions and global error handling
├── model        # Domain models and enums
├── repository   # In-memory data storage
└── service      # Business logic
