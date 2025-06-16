Feature: Product Search

    As a user browsing the store  
    I want to search for products by name or keyword  
    So that I can quickly find items I'm interested in

  Background:
    Given the user is on the main page

  Scenario Outline: Search products by name or keyword
    When the user enters "<query>" into the search bar
    And the user clicks the search button
    Then the search results page is displayed
    And the search results should include products matching "<query>"

    Examples:
      | query   |
      | T-shirt |
      | Sweater |
      | Mug     |
      | Cushion |