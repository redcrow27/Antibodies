@adminPage
Feature: Admin Page tests
  Background: Open Employee Management Page
    Given I open "Login Page"

#  Please try to make your steps re-usable
#  Scenario: This is sample scenario
#    Given This is sample scenario step

  Scenario Outline: Form should have all fields as Employee data table
    Given I enter with "<username>" credentials
    And I click "Sign in" button
    Then I verify fields are displayed with following data:
    |ID|
    |First Name|
    |Last Name |
    |Select role|
    |Select department|
    Examples:
    |username|
    |admin   |
    |user    |

  Scenario: When I fill out User Form  and click Enter Employee button it should populate in Employee data table
    Given I enter with "admin" credentials
    Then I click "Sign in" button
    And I fill out User Form  and click Enter Employee button
      |ID|
      |First Name|
      |Last Name |
      |Select role|
      |Select department|





