Feature: Login
  As a user I want to login so that I can access protected features

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be redirected to the home page
