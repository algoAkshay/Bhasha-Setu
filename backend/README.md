# Java / Spring Boot backend

This directory is the Java 17 migration target for Bhasha Setu. It uses Spring Boot 3, PostgreSQL through Spring Data JPA, and Redis for temporary conversation profiles. Eligibility remains deterministic: the Gemini boundary extracts explicit profile facts only; `EligibilityService` applies stored PostgreSQL rules and emits `ELIGIBLE`, `POTENTIALLY_ELIGIBLE`, `NEED_MORE_INFORMATION`, or `NOT_ELIGIBLE`.

## Run

Provide these environment values in the deployment platform; do not commit them:

```text
SPRING_DATASOURCE_URL=jdbc:postgresql://host:5432/bhashasetu
SPRING_DATASOURCE_USERNAME=...
SPRING_DATASOURCE_PASSWORD=...
REDIS_HOST=...
REDIS_PORT=6379
REDIS_PASSWORD=...
GEMINI_API_KEY=...              # required for text conversation extraction
GEMINI_MODEL=gemini-2.0-flash
```

Run the curated CSV import deliberately on a new database:

```sh
cd backend
mvn spring-boot:run -Dspring-boot.run.arguments="--bhashasetu.import-on-startup=true"
```

It is idempotent. Existing source keys are left untouched unless `IMPORT_OVERWRITE=true` is supplied. The importer never changes the CSV files.

Then run normally with `mvn spring-boot:run`, or build with `mvn package`. The Java service exposes `GET /health`, `GET /api/schemes`, `GET /api/schemes/{id}`, `POST /api/eligibility`, `POST /conversation`, and `DELETE /session/{id}`.

Speech recognition is intentionally an external boundary during this migration: `POST /speech-to-text` returns 501 until a reviewed Java-compatible STT provider is configured. It does not pretend to transcribe audio. The existing Python implementation remains available on the `python-main` reference branch during migration.
