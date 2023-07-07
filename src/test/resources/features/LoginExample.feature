Feature: Demoblaze application

  Scenario Outline: Login DemoBlaze with credentials
    Given I want to open the application url "<url>"
    When I login with "<user>" and "<password>" in step
    Then I verify the "<user>" in homepage

    Examples: 
      | url                        | user          | password |
      | https://www.demoblaze.com/ | santhoshjira  | abc      |
      | https://www.demoblaze.com/ | santhoshjira1 | abc      |
      | https://www.demoblaze.com/ | santhoshjira2 | abc      |
      | https://www.demoblaze.com/ | santhoshjira3 | abc      |
