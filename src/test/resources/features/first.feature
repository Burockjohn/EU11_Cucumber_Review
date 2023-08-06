Feature: Learning Cucumber

  Scenario:Print correct credentials
    Given I provide my credentials
    When I print them
    Then I should see them in the console


  Scenario: Print wrong credentials