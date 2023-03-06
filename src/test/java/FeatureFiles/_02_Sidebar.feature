Feature: Sidebar

  Background:
    Given the user is on the website

  Scenario Outline:
    Given the user selects a "<category>" on search dropdown
    And the user clicks the search button
    When The user clicks on all of the "<feature>" options from the sidebar
    Then the user can see the link has changed
    And the user can go back
    Examples:
      | category | feature |
      | Baby     | Seller  |

