@HistoryOrderUser
Feature: History Order Functionality

  @Positive @Bug
  Scenario: Verify history order can display user order history
    Given User already on the dashboard page
    And User already order a product
    When User click history order menu
    Then User navigate to the history order page
    And Product that ordered should be display

  @Positive
  Scenario: Verify detail button can display about detailed order information
    Given User already on the dashboard page
    When User click history order menu
    Then User navigate to the history order page
    When User click detail button on history order page
    Then Order information user should be displayed