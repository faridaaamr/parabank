Feature: Login Functionality

@Test
  Scenario: User login with username & password
    Given User fill the details For Login
    When User click on Login button
    Then User will be logged in successfully


@Test
  Scenario: User login with forget password
    Given User navigate to forget info page
    When  User fill info
    And   User click on find info button
    Then  User will get into successfully