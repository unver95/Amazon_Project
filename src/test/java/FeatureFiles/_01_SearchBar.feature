Feature: Search Bar
  Background:
    Given the user is on the website

  Scenario Outline: User can search for products using the search bar

    Given the user selects a "<category>" on search dropdown


    When the user types "<item>" into the search bar
    And the user clicks the search button
    Then the info bar message contains "<item>" name


    Examples:
     |category          | item         |
     |Sports & Outdoors | Bicycle      |
     |Toys & Games      | Teddy Bear   |
     |Books             | Harry Potter |

