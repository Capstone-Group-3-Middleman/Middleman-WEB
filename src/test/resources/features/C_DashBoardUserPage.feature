@DashboardUser
Feature: Dashboard Functionality

  @Positive
  Scenario: Verify product in dashboard page is displayed
    Given User login with valid email and password
    When User click login button
    And User click ok on alert login
    Then User navigate on the dashboard page
    And Product in the dashboard page will appear

  @Positive
  Scenario: Verify search feature can display product that keyword be inputted
    Given User already on the dashboard page
    When User input a keyword "galon" on the search field
    And User click search icon
    Then Product name "galon" will appear based on keyword that be inputted

  @Negative
  Scenario: Verify search feature can display product that are not in the list
    Given User already on the dashboard page
    When User input a keyword "roti" on the search field
    And User click search icon
    Then Message will appear "Data not found" on dashboard user

  @Positive @Bug
  Scenario: Verify product image in dashboard page is displayed
    Given User login with valid email and password
    When User click login button
    And User click ok on alert login
    Then User navigate on the dashboard page
    And Image in the dashboard page will display

