Feature: User SignUp
  Scenario Outline: New User Signup Scenario
    Given User is already on main Page
    Then User clicks on "signup" button
    Then User enters "<username>" and "<password>"
    Then User clicks on "signup" button
    And User is on "portfolio" page
    Then User logout from the system
    Examples:
      | username | password |
      | naveenk  | Test@1234 |
      |  tom     | test456  |