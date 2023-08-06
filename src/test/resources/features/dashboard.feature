Feature: Dashboard test

  Background:
    Given I logged into app

#DRY = Don't repeat yourself

  Scenario: Check navigation bar
    When I check student navigation bar
    Then I should see navigation options
      | Books           |
      | Borrowing Books |

  #@wip
  Scenario: Check ISBN number and book name match
    When choose classic from book categories
    Then ISBN number should match book name
      | 978 - 0140280197 | The 48 Laws of Power |
      | 9579-8799-5274   | Carrion Comfort      |
      | 8154-1063-5827   | Ego Dominus Tuus     |
