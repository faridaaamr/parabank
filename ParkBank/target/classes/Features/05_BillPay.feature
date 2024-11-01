Feature: Bill Pay Functionality

  Background:
    Given User fill the details For Login
    When User click on Login button

@Test
  Scenario: User navigates to bill pay Page and define payment

    When  user navigates to bill pay page
    When  user fill all bill pay page details
    And   user click on send payment
    Then  the user redirected to confirmation page
