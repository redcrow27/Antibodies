@loginPage
Feature: Login Page tests

  Background: : Login Page Test
    Given I open "Login Page"
#  Please try to make your steps re-usable
#  Scenario: This is sample scenario
#  Given This is sample scenario step


Scenario Outline: Login Page Test
  Given I enter with "<username>" credentials
  And I click "Sign in" button
  Examples:
    |username|
    |admin   |
    |user    |

