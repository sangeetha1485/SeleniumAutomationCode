Feature: Login Action

  Scenario Outline: Successful login with valid credentials
    Given user is on home page
    When user navigates to login page
    When user enters "<username>" and "<password>"
    Then Message displayed login successfully
    Then close the browser

    Examples: 
      | username  | password   |
      | sangeetha | Sangs_123$ |
      | jjjj      | password1  |
