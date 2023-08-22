Feature: Login Admin Functionality
  As a admin i want to login into website

  @Login
  Scenario: Login with valid email and password
    Given Admin already on the login page
    When Admin click sign in button
    And Admin input email "admin.middleman@gmail.com" and password "Admin123$"
    And Admin Click sign in button
    And Admin Click alert login
    Then Admin already on the my product page

  @Login
  Scenario Outline: Login with incorect email or password
    Given Admin already on the login page
    When Admin click sign in button
    And Admin input email "<email>" and password "<password>"
    And Admin Click sign in button
    Then Admin see error alert "<errorText>"
    When Admin Click alert login
    Examples:
      | email | password  | errorText                   |
      | aw    | qwerty123 | email or password incorrect |

  @Login
  Scenario Outline: Login with empty email or empty password
    Given Admin already on the login page
    When Admin click sign in button
    And Admin input email "<email>" and password "<password>"
    And Admin Click sign in button

#    When Click alert login
    Examples:
      | email                     | password |
      | admin.middleman@gmail.com |          |

