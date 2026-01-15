Feature: Login Functionality

  Scenario: User logs in with valid credentials
    Given User navigates to login page
    When User enters valid credentials
    Then User should see dashboard
