Feature: Application login


  Scenario: Home page default login
    Given User is on landing page
    When User login into application with "macska" and password "1234"
    Then Home page is populated
    And Cards are displayed are "true"

  Scenario: Home page default login
    Given User is on landing page
    When User login into application with "kutya" and password "4321"
    Then Home page is populated
    And Cards are displayed are "false"