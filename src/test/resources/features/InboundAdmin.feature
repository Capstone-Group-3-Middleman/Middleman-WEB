Feature: Inbound admin fuctionality

  @InboundAdmin
  Scenario: [IAF-01] Click button increment on inbound page
    Given Admin already login
    When Admin click button add product out "14"
    And Accept alert add product
    And Admin already on Inbound page
    And Admin click button plus "14"
    Then Amount increases "2"
    When Admin click button min "14"
    Then Number decreased "1"

  @InboundAdmin
  Scenario: [IAF-02] Click button submit on inbound page
    Given Admin already login
    When Admin click button add product out "14"
    And Accept alert add product
    And Admin go to inbound to verify product
    Then Product is displayed on inbound
    When Admin click button submit to

  @InboundAdmin @ServerError
  Scenario: [IAF-03] Click button history product in on inbound page
    Given Admin already login
    When Admin click button add product out "14"
    And Accept alert add product
    And Admin already on Inbound page
    And Admin click button submit to
    And Accept alert add product
    And Admin already on Inbound page
    And Admin click button history product in
    And Admin click button detail
    Then Verify detail product "14"

  @InboundAdmin
    Scenario: [IAF-04] Click button delete on inbound page
      Given Admin already login
      When Admin click button add product out "14"
      And Accept alert add product
      And Admin go to inbound to verify product
      Then Product is displayed on inbound
      When Delete product from inbound
      And click alert delete