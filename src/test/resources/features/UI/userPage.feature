@userPage
Feature: Login Page tests

#  Please try to make your steps re-usable
#  Scenario: This is sample scenario
#    Given This is sample scenario step

  Background: Open Employee Management Page
    Given I open "Login Page"

  Scenario Outline: I go to login page
    Given I enter with "<username>" credentials
    And I click "Sign in" button
    Then I verify headers are displayed with following data
    Examples:
      | username |
      | admin    |
      | user     |

