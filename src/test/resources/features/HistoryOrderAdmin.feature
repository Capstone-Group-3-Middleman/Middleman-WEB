Feature: History order admin

  @HistoryOrderAdmin
  Scenario: [HOA-01 ]Verify button detail display detail order information
    Given Admin already login
    When already on history order
    And click detail on history product
    Then Order information should be displayed