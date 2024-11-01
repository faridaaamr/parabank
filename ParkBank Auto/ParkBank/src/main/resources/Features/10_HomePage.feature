Feature: Home Page Testing

  @Test
  Scenario: Customer check navigation through Home page

    Given User navigate to Home Page
    When User click on About button
    Then User will be able to navigate successfully to about Page

  @Test
  Scenario: Verify the title and links on the Home Page
    Given The user is on the ParaBank home page
    When The page is loaded
    Then The title of the page should be "ParaBank | Welcome | Online Banking"
    Then The login button should be visible
    Then The Register button should be visible
    Then The Forgot Login Info button should be visible
