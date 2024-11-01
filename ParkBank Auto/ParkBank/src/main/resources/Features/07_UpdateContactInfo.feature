Feature: update contact info Functionality

  Background:
    Given User fill the details For Login
    When User click on Login button
    Given user navigate to update contact info



@Test

  Scenario: user updates account information First name and Last Name successfully

    When the user clear the filed place and write the new First Name and Last Name
    Then click on the update profile button
    And  contact info is updated successfully


@Test
  Scenario: user updates account information Address and City And State successfully
    When    the user clear the filed place and write the new Address City State
    Then    click on the update profile button
    And     contact info is updated successfully



@Test
  Scenario: user updates account information Zip Code and Phone successfully
    When    the user clear the filed place and write the new ZipCode And Phone
    Then    click on the update profile button
    And     contact info is updated successfully