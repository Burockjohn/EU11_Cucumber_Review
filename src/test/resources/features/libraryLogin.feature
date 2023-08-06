Feature: Login test for library project

  Background:
    Given I am on the login page

  @login
  Scenario: login with valid credentials
    When I enter valid credentials and login
    Then I should be on the dashboard

  @login
  Scenario: login with invalid credentials
    When I enter invalid credentials and login
    Then I shouldn't  be on the dashboard

@wip
    Scenario: login with different roles
      When I enter "student" credentials and login
      Then I should see "student" page

