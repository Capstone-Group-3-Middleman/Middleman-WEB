@MyCartUser
Feature: My Cart User Functionality

  @Positive @Bug
  Scenario: Add product to my cart
    Given User already on the dashboard page
    When User click add button on product dashboard
    Then Alert my cart message will appear "success"
    When User click ok on alert my cart
    And User click my cart menu
    Then User navigate to my cart page
    And Product that adding should be appear