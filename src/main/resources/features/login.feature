Feature: Login

  @test
  Scenario Outline: Valid login
    Given User navigates to login page
  	When User enters "<userName>" credentials
    Then User enters valid credentials
		|Username|pass|
		|abc|abc|
		
    Examples:
		|userName|password|
		|aba|asa|