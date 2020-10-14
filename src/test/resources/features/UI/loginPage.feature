@loginPage
Feature: Login Page tests

  Background: : Login Page Test
    Given I open "Login Page"
#  Please try to make your steps re-usable
#  Scenario: This is sample scenario
#  Given This is sample scenario step


Scenario: Login Page Test
  Given I verify "username" field is displayed
  And I verify "password" field is displayed
  Then I verify "sign in" button is displayed
  Then I enter with "admin" credentials
  And I verify "sign in" button is enabled



