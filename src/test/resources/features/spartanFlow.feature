Feature: Test Spartan API with complete CRUD operations

  @wip
  Scenario: Read data from Spartan API
    Given user sends a request to Mock API for mock Spartan Data
    When User uses Mock Data to create a Spartan
    When Users send a request to Spartan API id 0
    Then Created Spartan has the same information with POST request
    And User Updates all the fields of created Spartan
    And User deletes Spartan 0
