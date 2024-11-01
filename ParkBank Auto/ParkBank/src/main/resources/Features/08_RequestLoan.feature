Feature: Request Loan Functionality

  Background:
    Given User fill the details For Login
    When  User click on Login button
    Given User Navigate to the Request Loan page
@Test
  Scenario: User Request loan with valid data
     And   User Request loan amount
    Then   User Submit the loan request
@Test
  Scenario: User Verify Error Message if Insufficient Funds in Selected Account
    And   User Enter the loan amount and down payment and select the account with insufficient funds
    Then  User Submit the loan request

