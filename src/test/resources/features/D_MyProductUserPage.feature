@MyProductUser
Feature: My Product User Functionality

  @Negative @Bug
  Scenario: Add user product with invalid data add inputting number to all field
    Given User already on the dashboard page
    When User click my product menu
    And User click add product button
    And User input product name as "10007"
    And User input unit as "10007"
    And User input stock as "107"
    And User input price as "6000"
    And User input images "gambar1.jpg"
    And User click add button
    Then Alert my product message will appear "wrong input"

  @Positive
  Scenario: Add user product with valid data
    Given User already on the dashboard page
    When User click my product menu
    And User click add product button
    And User input product name as "sprite no sugar 8"
    And User input unit as "botol"
    And User input stock as "100"
    And User input price as "6000"
    And User input images "gambar1.jpg"
    And User click add button
    Then Alert my product message will appear "success create product"
    When User click ok on alert my product
    Then User Product success created with product name is "sprite no sugar 8"

  @Negative
  Scenario: Add user product with invalid data add empty name
    Given User already on the dashboard page
    When User click my product menu
    And User click add product button
    And User input product name as ""
    And User input unit as "botol"
    And User input stock as "100"
    And User input price as "6000"
    And User input images "gambar1.jpg"
    And User click add button
    Then Alert my product message will appear "wrong input"

  @Negative
  Scenario: Add user product with invalid data add empty unit
    Given User already on the dashboard page
    When User click my product menu
    And User click add product button
    And User input product name as "sprite rasa jruk"
    And User input unit as ""
    And User input stock as "100"
    And User input price as "6000"
    And User input images "gambar1.jpg"
    And User click add button
    Then Alert my product message will appear "wrong input"

  @Negative
  Scenario: Add user product with invalid data add empty stock
    Given User already on the dashboard page
    When User click my product menu
    And User click add product button
    And User input product name as "sprite rasa jruk"
    And User input unit as "botol"
    And User input stock as ""
    And User input price as "6000"
    And User input images "gambar1.jpg"
    And User click add button
    Then Alert my product message will appear "wrong input"

  @Negative
  Scenario: Add user product with invalid data empty price
    Given User already on the dashboard page
    When User click my product menu
    And User click add product button
    And User input product name as "sprite rasa jruk"
    And User input unit as "botol"
    And User input stock as "100"
    And User input price as ""
    And User input images "gambar1.jpg"
    And User click add button
    Then Alert my product message will appear "wrong input"

  @Negative
  Scenario: Add user product with invalid data without image
    Given User already on the dashboard page
    When User click my product menu
    And User click add product button
    And User input product name as "sprite rasa jruk"
    And User input unit as "botol"
    And User input stock as "100"
    And User input price as "6000"
    And User click add button
    Then Alert my product message will appear "failed to get file"

  @Negative
  Scenario: Add user product with data product already added
    Given User already on the dashboard page
    When User click my product menu
    And User click add product button
    And User input product name as "sprite no sugar 1"
    And User input unit as "botol"
    And User input stock as "50"
    And User input price as "7000"
    And User input images "gambar1.jpg"
    And User click add button
    Then Alert my product message will appear "there is an error in internal server"

  @Negative @Bug
  Scenario: Edit user product with data inputting number to all field
    Given User already on the dashboard page
    When User click my product menu
    And User click edit product user
    And User edit product name as "111111"
    And User edit unit as "111111"
    And User edit stock as "111111"
    And User edit price as "10101011"
    And User edit images "gambar1.jpg"
    And User click edit button
    Then Alert my product message will appear "wrong input"

  @Positive
  Scenario: Edit user product with valid data
    Given User already on the dashboard page
    When User click my product menu
    And User click edit product user
    And User edit product name as "sprite stroberi update 6"
    And User edit unit as "botol"
    And User edit stock as "100"
    And User edit price as "7500"
    And User edit images "gambar1.jpg"
    And User click edit button
    Then Alert my product message will appear "success update data"
    And User click ok on alert my product

  @Negative
  Scenario: Edit user product with data name already in list product
    Given User already on the dashboard page
    When User click my product menu
    And User click edit product user
    And User edit product name as "aqua air mineral"
    And User edit unit as "botol"
    And User edit stock as "100"
    And User edit price as "7500"
    And User edit images "gambar1.jpg"
    And User click edit button
    Then Alert my product message will appear "data not found"

  @Positive
  Scenario: Canceled edit user product
    Given User already on the dashboard page
    When User click my product menu
    And User click edit product user
    And User click cancel button on modal product user
    Then User back to my product page

  @Positive
  Scenario: Canceled delete user product
    Given User already on the dashboard page
    When User click my product menu
    And User click delete button
    And User click no button
    Then User back to my product page

  @Positive
  Scenario: Success Delete user product
    Given User already on the dashboard page
    When User click my product menu
    And User click delete button
    And User click yes button
    Then Alert my product message will appear "success delete product"
    When User click ok on alert my product
    Then Product name "sprite stroberi updatae 6" already deleted