Feature: Transaction

  @RegressionTest @End2End
  Scenario Outline: Deposit Scenario

    Given User is already on main Page
    Then User clicks on "signup" button
    Then User enters "<username>" and "<password>"
    Then User clicks on "signup" button
    And User is on "portfolio" page
    Then User performs "<operation>" operation
    And User is on "<operation>" page
    Then User enters "<amount>"
    And User checks "fee"
    Then User clicks on "<operation>" button
    And User is on "portfolio" page
    And User checks "Balance"
    Then User logout from the system
    Examples:
      | username | password  | amount | operation |
      | naveenk  | Test@1234 | 1000   | deposit   |
      | naveenk  | Test@1234 | 1000   | withdraw  |
