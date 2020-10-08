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
      | ID                |
      | First Name        |
      | Last Name         |
      | Select role       |
      | Select department |
    Examples:
      | username |
      | admin    |
      | user     |

  @UserFill-out_Form
  Scenario: When I fill out User Form  and click Enter Employee button it should populate in Employee data table
    Given I enter with "admin" credentials
    Then I click "Sign in" button
    And I fill out User Form  and click Enter Employee button
      | ID                |
      | First Name        |
      | Last Name         |
      | Select role       |
      | Select department |
    And I verify the Data is populate in Employee data table

  @Count_Option
  Scenario Outline: As all roles I need an option to limit the display count of the Employee data table.
    Given I enter with "<username>" credentials
    And I click "Sign in" button
    Then I verify the buttons to limit display count are functional:
      | 10btn   |
      | 25btn   |
      | 50btn   |
      | All_bnt |
    Examples:
      | username |
      | admin    |
      | user     |


  @header
  Scenario Outline: Employee data table should have following headers:
    Given I enter with "<username>" credentials
    And I click "Sign in" button
    Then I verify headers are displayed with following data:
      | ID         |
      | First      |
      | Last       |
      | Role       |
      | Department |
    Examples:
      | username |
      | admin    |
      | user     |

  @search
  Scenario Outline: As all roles I should be able to search for any employee based on any keyword in Employee data table
    Given I enter with "<username>" credentials
    And I click "Sign in" button
    Then I verify search for any employee based on any keyword such as "SDET" in "<page name>" Employee data table
    Examples:
      | username | page name  |
      | admin    | admin page |
      | user     | user page  |

  @inputForm
  Scenario: Verify Employee Input form and Employee data table displayed.
    Given I enter with "admin" credentials
    And I click "Sign In" button
    Then I verify same Employee Input form and Employee data table displayed


  @token
  Scenario: Verify Copy Token button will give Bearer Token
    Given I enter with "admin" credentials
    And I click "Sign In" button
    Then I verify Token is available

  @AddNewroleAndDelete
  Scenario: I add new role and delete the existing one
    Given I enter with "admin" credentials
    And I click "Sign in" button
    And I create new role
    Then I delete the existing one









