Feature: Test Spartan API with complete CRUD operations

  @wip
  Scenario: Read data from Spartan API
    Given user sends a request to Mock API for mock Spartan Data
    When User uses Mock Data to create a Spartan
    When Users send a request to Spartan API id 7
