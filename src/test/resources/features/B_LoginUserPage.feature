@LoginUser
Feature: Login User Functionality

  @Positive
  Scenario: Login with valid email and password
    Given User already on the website
    And User click sign in button
    When User input email "laundry@laun.com" and password "qwerty123"
    And User click login button
    And User click ok on alert login
    Then User navigate on the dashboard page

#  @Negative
#  Scenario: Login with invalid email and valid password
#    Given User already on the website
#    And User click sign in button
#    When User input email "testingtoko@test123.com" and password "qwerty123"
#    And User click login button
#    Then Alert login message will appear "email or password incorrect"
#
#  @Negative
#  Scenario: Login with valid email and invalid password
#    Given User already on the website
#    And User click sign in button
#    When User input email "laundry@laun.com" and password "loremipsum123"
#    And User click login button
#    Then Alert login message will appear "email or password incorrect"
#
#  @Negative
#  Scenario: Login with invalid email and invalid password
#    Given User already on the website
#    And User click sign in button
#    When User input email "testingtoko@test123.com" and password "loremipsum123"
#    And User click login button
#    Then Alert login message will appear "email or password incorrect"




