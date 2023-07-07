Feature: Demoblaze application

  Scenario: Login DemoBlaze with credentials
    Given I want to open the application url "https://www.demoblaze.com/"
    When I login with "santhoshjira" and "abc" in step
    Then I verify the "santhoshjira" in homepage

