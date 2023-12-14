Feature: Verify login successfully

  @login
  Scenario: Verify login with valid credentials
    Given user on the register page
    Then create a new valid user
    When go to the login page
    And user login into system
    Then user can login to system successfully
    When go to the my account page
    Then verify valid credentials
