Feature: User Login
  Scenario Outline: Login Test Scenario

    Given User is already on main Page
    Then User enters "<username>" and "<password>"
    Then User clicks on "login" button
    And User is on "portfolio" page
    Then User logout from the system
    Examples:
      | username | password |
      | naveenk  | test@123 |
      |  tom     | test456  |
