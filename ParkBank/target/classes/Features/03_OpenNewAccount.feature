
Feature: Open New Account Functionality
  Background:
    Given User fill the details For Login
    When  User click on Login button

  @Test

  Scenario: Open New Account

    Then  user navigate open new account
    And   the user choose the type of account
    And   I click on open new account button
#    Then  the successful Message send