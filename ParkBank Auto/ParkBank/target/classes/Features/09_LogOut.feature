Feature: Log out Functionality

  Background:
    Given User fill the details For Login
    When User click on Login button


  Scenario: User logs out of the ParaBank website before requesting a loan.

    When User click on LogOut button
    Then User will be logged Out successfully



  Scenario: User closes the browser without logging out.

    When User Close the browser without logging out.
    And  Reopen the browser and navigate back to the ParaBank website.
    Then The user should be required to log in again

#    When User click on LogOut button
#    And  Reopen the browser and navigate back to the Parabank website
#    Then User Open another tab and navigate to the ParaBank website.


  Scenario: Multiple tabs or windows are opened, and the user logs out from one tab.

    When User Open another tab and navigate to the ParaBank website.
    And  User click on LoggedOut button in one of the tabs
    When User In the other tab, attempt to navigate to a protected page
    Then User is logged out of all tabs