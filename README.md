# Security Alert Triage API

A small Spring Boot REST API for creating, viewing, and updating security alerts.

This project was built as a focused Java/Spring Boot interview preparation project. The goal is to demonstrate clean REST API structure, controller/service/repository separation, DTOs, request validation, custom exception handling, Maven, Git, and unit testing.

The project intentionally keeps the implementation small so the core design is easy to understand and explain. It uses an in-memory repository instead of a database, but the layered structure would allow the repository to be replaced later with a persistent database implementation.

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
├── exception    # Custom exceptions and global error handling
├── model        # Domain models and enums
├── repository   # In-memory data storage
└── service      # Business logic

## Current Endpoints

POST /alerts
GET /alerts
GET /alerts/{id}
PATCH /alerts/{id}/status

## Testing

The project includes service-layer tests for the core alert behavior.

Current tests cover:

- Creating an alert assigns server-owned fields such as `id`, `status`, `createdAt`, and `updatedAt`
- Creating an alert preserves client-provided fields such as `title`, `description`, `severity`, and `source`
- Looking up a missing alert throws `AlertNotFoundException`
- Updating alert status changes the status and refreshes `updatedAt`

Run the test suite with:

```bash
mvn test

