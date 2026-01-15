BDD Cucumber Sample Project

Structure:
- pom.xml
- src/test/resources/features/*.feature
- src/test/resources/testdata/*.json
- src/test/java/com/example/{base,steps,pages,utils}

Run tests:

# Using system Maven (if installed):
mvn test

# Using the included lightweight wrapper (Windows PowerShell):
# From PowerShell (recommended):
./mvnw.ps1 test

# Or from cmd.exe:
./mvnw.cmd test

Notes:
- The wrapper downloads Apache Maven (3.9.4) into `.mvn/apache-maven` on first run.
- Ensure PowerShell can download files (network access) and you have permissions to create files in the repo.
- `DriverFactory` uses ChromeDriver; place `chromedriver.exe` on your PATH or update `DriverFactory`.
