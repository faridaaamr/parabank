Feature: ParaBank Registration Functionality


  Background:
    Given the user is on the ParaBank registration page

@Test
  Scenario: Successful registration with valid data
    When the user enters valid registration details
    And submits the registration form
    Then the user should see a registration success message

@Test
  Scenario: Unsuccessful registration with missing required fields
    When the user submits the form without filling required fields
    Then the user should see error messages for missing fields


