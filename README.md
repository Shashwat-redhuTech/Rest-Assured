# RestAssured Automation Framework

> RestAssured-based API automation framework built with Java and Maven. Designed to be imported and run from Eclipse (Maven project).

---

## Overview

This repository contains a RestAssured automation framework for testing REST APIs. It is implemented in Java and managed with Maven, and intended to be opened and executed in Eclipse (as a Maven project).

## Prerequisites

* **Java JDK** — latest LTS or newer (Java 17+ recommended).
* **Maven** — latest stable release.
* **Eclipse IDE** with Maven support (Eclipse IDE for Java Developers or similar).
* Internet access to download Maven dependencies on first build.

> Verify installed versions:

```bash
java -version
mvn -version
```

## Importing into Eclipse

1. Open Eclipse.
2. `File` → `Import...` → `Maven` → `Existing Maven Projects`.
3. Browse to the root folder of this project and finish the import.
4. Wait for Maven to download dependencies (check `Maven Dependencies` in Project Explorer).

## Build & Run (CLI)

From the project root you can use Maven commands:

* Clean and run the full test suite:

```bash
mvn clean test
```

* Run a specific test class (Surefire syntax):

```bash
mvn -Dtest=MyTestClass test
```

* Skip tests (useful for compiling/installing without execution):

```bash
mvn clean install -DskipTests
```

## Run from Eclipse

* Right-click the project → `Run As` → `Maven test`.
* Or run a single test class by right-clicking on the test file → `Run As` → `JUnit Test` (if tests are JUnit-based).

## Project Structure (example)

```
rest-assured-framework/
├─ pom.xml                # Maven POM with dependencies and plugins
├─ src/
│  ├─ main/
│  │  └─ java/             # Reusable helpers, clients, utilities
│  └─ test/
│     └─ java/             # Test classes and test data
│        ├─ day1/
│        ├─ day2/
│        └─ resources/     # Test resources (JSON payloads, fixtures)
└─ README.md
```

Adjust this layout as needed — the current repository follows a similar folder structure.

## Dependencies & Plugins

* RestAssured
* JUnit / TestNG (depending on your chosen test framework)
* Maven Surefire / Failsafe plugins for test execution
* (Optional) Allure or ExtentReports for reporting

These are managed in `pom.xml`. Update versions there to match your environment (the POM is configured for a modern Java + Maven setup).

## Common Tasks

* **Add a new test**: create a new class under `src/test/java` and write tests using RestAssured HTTP calls and assertions.
* **Add request/response payloads**: store JSON files under `src/test/resources` and load them from tests.
* **Create reusable clients/helpers**: put them under `src/main/java` so tests can reuse code.

## Test Reports

* If using Surefire, test results (XML) are written to `target/surefire-reports/`.
* Configure a reporting plugin (Allure / ExtentReports) in the `pom.xml` to generate HTML reports.

## Troubleshooting

* **Dependencies not downloading**: run `mvn -U clean test` to force update repositories.
* **Java version issues in Eclipse**: ensure Project `Java Build Path` and `Installed JREs` are set to the same Java version used by Maven.
* **Maven lifecycle problems**: right-click project → `Maven` → `Update Project...` and select `Force Update of Snapshots/Releases`.

## CI / Automation (suggested)

* Configure a CI job (GitHub Actions, Jenkins, GitLab CI) to run `mvn clean test` on each PR.
* Publish test reports/artifacts from the CI server for visibility.

## Contributing

* Follow the existing project structure when adding tests or utilities.
* Open issues or PRs for feature work or fixes.

---

If you want, I can also add a ready-to-use `pom.xml` template with commonly used dependencies and plugins for RestAssured + JUnit/TestNG.
