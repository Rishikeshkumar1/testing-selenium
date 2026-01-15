# BDD Cucumber Sample Repository

A Behavior-Driven Development (BDD) testing framework using Cucumber, Selenium, and JUnit 5 for automated web UI testing.

## Project Overview

This project demonstrates a complete BDD automation framework with:
- **Cucumber 7.14.0** - For writing acceptance tests in Gherkin language
- **Selenium 4.11.0** - For web browser automation
- **JUnit 5** - For test execution
- **Java 21 LTS** - Target runtime environment

## Project Structure

```
bdd-cucumber-sample-repo/
│
├── pom.xml                          # Maven configuration with dependencies
├── README.md                        # This file
│
└── src/main/
    │
    ├── features/                    # Cucumber feature files (Gherkin scripts)
    │   └── login.feature           # Login scenario definitions
    │
    └── java/com/example/           # Java source code organized by package
        │
        ├── base/                    # Base classes
        │   └── TestBase.java       # Base test class with WebDriver setup
        │
        ├── pages/                   # Page Object Model classes
        │   └── LoginPage.java      # Login page object with selectors and actions
        │
        ├── steps/                   # Cucumber step definitions
        │   └── LoginSteps.java     # Step implementations for login scenarios
        │
        └── utils/                   # Utility classes
            └── DriverFactory.java   # WebDriver factory for browser initialization
```

## Directory Details

### `src/main/features/`
Contains Cucumber feature files written in Gherkin syntax. These define test scenarios in human-readable format.

- **login.feature** - Login functionality tests

### `src/main/java/com/example/`

#### `base/`
- **TestBase.java** - Base class providing common test setup and teardown, WebDriver initialization

#### `pages/`
- **LoginPage.java** - Page Object representing the login page with:
  - Web element locators (@FindBy annotations)
  - Action methods (enterUsername, enterPassword, login, etc.)

#### `steps/`
- **LoginSteps.java** - Cucumber step definitions that map Gherkin steps to Java code:
  - `@Given` - Test setup steps
  - `@When` - User action steps
  - `@Then` - Assertion/verification steps

#### `utils/`
- **DriverFactory.java** - WebDriver factory class that:
  - Manages WebDriver instantiation (ThreadLocal for thread safety)
  - Handles driver initialization and cleanup

## Technology Stack

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 21 LTS | Programming language |
| Maven | 3.9.12 | Build and dependency management |
| Cucumber | 7.14.0 | BDD framework |
| Selenium | 4.11.0 | Web browser automation |
| JUnit | 5.9.3 | Test execution engine |
| Jackson | 2.15.2 | JSON data processing |

## Dependencies

The project includes the following Maven dependencies:

```xml
<!-- Cucumber Framework -->
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.14.0</version>
</dependency>

<!-- Selenium WebDriver -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.11.0</version>
</dependency>

<!-- JUnit 5 -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.3</version>
</dependency>

<!-- JSON Processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
</dependency>
```

## Package Naming Convention

The project uses **Reverse Domain Notation** for Java packages:
- `com.example` - Base package (follows Java convention)
- `com.example.base` - Base classes
- `com.example.pages` - Page Objects
- `com.example.steps` - Step definitions
- `com.example.utils` - Utility classes

This prevents naming conflicts and organizes code logically as the project grows.

## Building the Project

### Prerequisites
- Java 21 LTS
- Maven 3.9.12 or higher

### Build Commands

```bash
# Clean and build the project
mvn clean install

# Compile only
mvn compile

# Run tests
mvn test
```

## Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LoginStepsTest

# Run with specific pattern
mvn test -Dtest=*Steps
```

## Key Design Patterns

### 1. **Page Object Model (POM)**
Web elements and actions are encapsulated in page classes (`LoginPage.java`), promoting maintainability and reusability.

### 2. **Step Definitions Pattern**
Cucumber steps are implemented in dedicated classes (`LoginSteps.java`), separating test logic from implementation details.

### 3. **Factory Pattern**
WebDriver is managed through `DriverFactory.java` using the factory pattern for centralized driver management.

### 4. **ThreadLocal for Thread Safety**
The `DriverFactory` uses `ThreadLocal<WebDriver>` to ensure thread-safe WebDriver instances in parallel test execution.

## Project Features

✅ BDD approach using Gherkin syntax  
✅ Page Object Model for maintainable test code  
✅ Centralized WebDriver management  
✅ Java 21 LTS compatibility  
✅ Maven-based build automation  
✅ Cucumber integration with JUnit 5  
✅ Selenium 4 for modern web automation  

## Future Enhancements

- Add test data management (CSV, Excel support)
- Implement reporting (Cucumber Reports, Allure)
- Add cross-browser testing configuration
- Parallel test execution setup
- CI/CD pipeline integration

## License

This project is provided as-is for educational and testing purposes.
