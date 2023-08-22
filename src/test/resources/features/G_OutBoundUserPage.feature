@OutBoundUser
Feature: Outbound User Functionality

  @Positive
  Scenario: Verify user can add product to outbound menu
    Given User already on the dashboard page
    When User click my product menu
    And User click plus icon
    Then Alert my product message will appear "success creating a cart"
    When User click ok on alert my product
    And User click outbound menu
    Then User navigate to the outbound page
    And Product that added should be appear

  @Positive @ServerError
  Scenario: Verify submit button can removed the product that added
    Given User already added product to outbound
    When User click outbound menu
    Then User navigate to the outbound page
    When User click submit button on outbound user
    Then Alert outbound message will appear "success input data"
    When User click ok on alert outbound
    Then User navigate to the my product user page

  @Positive
  Scenario: Verify history product out can display information about product that be removed
    Given User already on the outbound page
    When User click history product out button
    Then User navigate to the history product out page
    When User click detail button
    Then User navigate to detail product out page
    And Information about product should be displayed

  @Positive
  Scenario: Verify delete button on outbound page can removed product to the my product page
    Given User already added product to outbound
    When User click outbound menu
    Then User navigate to the outbound page
    When User click delete button on the outbound page
    Then Alert outbound message will appear "Success delete product"
    When User click ok on alert outbound
    Then Product should be removed
