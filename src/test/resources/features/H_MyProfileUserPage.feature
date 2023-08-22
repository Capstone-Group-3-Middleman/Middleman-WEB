@MyProfileUser
Feature: My Profile User Functionality

  @Positive
  Scenario: Edit user with valid data
    Given User already on the my profile page
    When User click edit button on my profile page
    And User input shop name as "shop test 123"
    And User input email as "laundry@laun.com"
    And User input phone number as "081122233345"
    And User input address as "rahasia update"
    And User click edit button on modal profile
    Then Alert my profile message will appear "success update data"
    When User click ok on alert my profile
    Then Data should be updated

  @Positive
  Scenario: Verify my profile can display information about user
    Given User already on the dashboard page
    When User click account icon
    And User click my profile menu
    Then User navigate to my profile page
    And User email "laundry@laun.com" is displayed
    And User phone number "081122233345" is displayed



  @Negative
  Scenario: Edit User with email already registered
    Given User already on the my profile page
    When User click edit button on my profile page
    And User input shop name as "shop test 123"
    And User input email as "testingtoko@test123.com"
    And User input phone number as "08113344556"
    And User input address as "rahasia"
    And User click edit button on modal profile
    Then Alert my profile message will appear "failed update data users, your email or phone already registerd"

  @Negative
  Scenario: Edit user with phone number already registered
    Given User already on the my profile page
    When User click edit button on my profile page
    And User input shop name as "shop test 123"
    And User input email as "laundry@laun.com"
    And User input phone number as "087730126512"
    And User input address as "rahasia"
    And User click edit button on modal profile
    Then Alert my profile message will appear "failed update data users, your email or phone already registerd"

  @Positive
  Scenario: Logout User
    Given User already on the dashboard page
    When User click account icon
    And User click logout button
    And User click yes logout
    Then User navigate to website middleman-immersive.vercel.app

#   @Positive
#  Scenario: Delete user
#    Given User already on the my profile page
#    When User click delete button on my profile page
#    And User click yes button on my profile page
#    Then Alert my profile message will appear "success delete data"
#    When User click ok on alert my profile
#    Then User navigate to website middleman-immersive.vercel.app
