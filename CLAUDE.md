# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
./mvnw clean package

# Run
./mvnw spring-boot:run

# Run tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=BarberServiceControllerTest
```

The app requires environment variables: `DB_URL`, `DB_USER`, `DB_PASS` (PostgreSQL connection). `application.properties` is gitignored — create it locally.

## Architecture

Spring Boot 3 REST API with a classic layered structure:

```
controller/ → service/ → repository/ → model/
```

- **model/** — JPA entities (UUID primary keys, Lombok annotations)
- **repository/** — Spring Data JPA interfaces extending `JpaRepository`
- **service/** — Business logic; inject repositories here
- **controller/** — REST endpoints; inject services here
- **config/** — Cross-cutting config (e.g., `WebConfig.java` has CORS allowing `localhost:3000`)

## Database & Migrations

- PostgreSQL via Spring Data JPA; `ddl-auto=none` (no auto schema changes)
- **Flyway** manages all schema changes — migrations in `src/main/resources/db/migration/`
- Naming convention: `V{n}__{description}.sql` (e.g., `V2__create_barber_service.sql`)
- Always add a new migration file for schema changes; never edit existing ones

## Key Conventions

- Entities use `UUID` as primary key type
- CORS is configured globally in `WebConfig.java` — add new allowed origins there
- New features follow the pattern: entity → repository → service → controller
- **All entities must include `createdAt` and `updatedAt` fields** using `@CreationTimestamp` / `@UpdateTimestamp` (Hibernate), mapped to `created_at` / `updated_at` TIMESTAMP columns. The `createdAt` field must have `updatable = false`. Only expose getters (no setters) since Hibernate manages these values automatically.
