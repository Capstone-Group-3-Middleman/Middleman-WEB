@RegisterUser
Feature: Register User Functionality

  @Positive
  Scenario: Register user with valid data
    Given User already on the website
    When User click sign up button
    Then User already on the register page
    When User input shop name "toko test shop"
    And User input email "test7@test123.com"
    And User input phone number "08666666667"
    And User input password "qwerty123"
    And User input address "anonymous"
    And User click register button
    Then Alert register user message will appear "register success"
    When User click ok on alert register
    Then User navigate to the login page

  @Negative
  Scenario: Register user with email already registered
    Given User already on the website
    When User click sign up button
    Then User already on the register page
    When User input shop name "toko test shop"
    And User input email "shoptest@test123.com"
    And User input phone number "0811122233344"
    And User input password "qwerty123"
    And User input address "anonymous"
    And User click register button
    Then Alert register user message will appear "your email or handphone number is already registered"

  @Negative
  Scenario: Register user with phone number already registered
    Given User already on the website
    When User click sign up button
    Then User already on the register page
    When User input shop name "toko test shop"
    And User input email "testing321@test.com"
    And User input phone number "087645382234"
    And User input password "qwerty123"
    And User input address "anonymous"
    And User click register button
    Then Alert register user message will appear "your email or handphone number is already registered"
