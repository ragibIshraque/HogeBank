Feature: Transaction

  Scenario Outline: Deposit Scenario

    Given User is already on main Page
    Then User enters "<username>" and "<password>"
    Then User clicks on "login" button
    And User is on "portfolio" page
    Then User performs "deposit" operation
    And User is on "deposit" page
    Then User enters "<amount>"
    And User checks "fee"
    Then User clicks on "deposit" button
    And User is on "portfolio" page
    And User checks "Balance"
    Then User logout from the system
    Examples:
      | username | password | amount |
      | naveenk  | test@123 |        |
      | tom      | test456  |        |