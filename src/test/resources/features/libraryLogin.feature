Feature: Login test for library project

  @wip
  Scenario: login with valid credentials
    Given I am on the login page
    When I enter valid credentials and login
    Then I should be on the dashboard

  @wip
  Scenario: login with invalid credentials
    Given I am on the login page
    When I enter invalid credentials and login
    Then I shouldn't  be on the dashboard

