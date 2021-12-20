Feature: User SignUp

  Scenario Outline: New User Signup Scenario
    Given User is already on main Page
    Then User clicks on "signup" button
    Then User enters "<username>" and "<password>"
    Then User clicks on "signup" button
    And User checks "<errorMessage>"
    Examples:
      | username | password                             | errorMessage       |
      |          | Test@1234                            | userNameBlank      |
      | test 1   | Test@1234                            | userNameWhiteSpace |
      | test1    | Test@12                              | passwordLess       |
      | test1    | 123456789123456789123456789123456789 | passwordMore       |
      | test1    | Testtesttest                         | passwordNumber     |
      | test1    | test@1234                            | passwordUpperCase  |
      | ragib    | Test@1234                            |                    |
      | test1    | Test@1234                            |                    |
