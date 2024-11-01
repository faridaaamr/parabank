Feature: Find Transactions Functionality

  Background:
    Given User fill the details For Login
    When User click on Login button
@Test
  Scenario: Find transaction by id
    And User select the account to get the transaction Id
    And User navigate to find transaction page
    And User fill the transaction Id
    And User click on search id button
    And User should see the transaction details
  @Test
  Scenario: Find transaction by date
    When User select the account to get the transaction date
    And User navigate to find transaction page
    And User fill the transaction date
    And User click on search date button
    Then User should see the transaction details of this date
  @Test
  Scenario: Find transaction by Date Range
    And User navigate to find transaction page
    And User fill the transaction Date Range
    And User click on search Date Range button
    Then User should see the transaction details of this Date Range
  @Test
  Scenario: Find transaction by Amount
    And User navigate to find transaction page
    And User fill the transaction Amount
    And User click on search Amount button
    Then User should see the transaction details of this Amount
