@adminPage
Feature: Admin Page tests

  Background: Open Employee Management Page
    Given I open "Login Page"

#  Please try to make your steps re-usable
#  Scenario: This is sample scenario
#    Given This is sample scenario step

  @empDataTable
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
  Scenario Outline: When I fill out User Form "<form>" as a "Admin' and click Enter Employee button
    Given I enter with "admin" credentials
    When I click "Sign in" button
    Then I fill out User Form "<form>" and click Enter Employee button
      | ID                |
      | First Name        |
      | Last Name         |
      | Select role       |
      | Select department |
    And I verify the Data is populate in Employee data table
    Examples:
      | form                    |
      | all fields              |
      | with out select options |
      | leaving fields empty    |
  @UserFill-out_Form
  Scenario Outline: When I fill out User Form "<form>" as a "User" and click Enter Employee button
    Given I enter with "user" credentials
    When I click "Sign in" button
    Then I fill out User Form "<form>" and click Enter Employee button
      | ID                |
      | First Name        |
      | Last Name         |
      | Select role       |
      | Select department |
    And I verify the Data is populate in Employee data table
    Examples:
      | form                    |
      | all fields              |
      | with out select options |
      | leaving fields empty    |

  @Count_Option
  Scenario Outline: As "<username>" I need an option to limit the display count of the Employee data table.
    Given I enter with "<username>" credentials
    And I click "Sign in" button
    Then I verify the buttons to limit display count are functional:
      | 10 users  |
      | 25 users  |
      | 50 users  |
      | All users |
    Examples:
      | username |
      | Admin    |
      | User     |


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


  @search @userPage
  Scenario Outline: I should be able to search for any employee based on any keyword in Employee data table
    Given I enter with "<username>" credentials
    And I click "Sign in" button
    Then I enter "<keyword>" keyword in Filter field
    And I click "Search" button
    Then I verify "<keyword>" keyword in "<page name>" Employee data table
    Examples:
      | username | page name  | keyword |
      | admin    | admin page | SDET    |
      | user     | user page  | SDET    |


  @inputForm
  Scenario Outline: Verify Employee Input form and Employee data table is displayed as a "<username>".
    Given I enter with "<username>" credentials
    And I click "Sign In" button
    Then I verify same Employee Input form and Employee data table displayed
    Examples:
      | username |
      | admin    |
      | user     |


  @token
  Scenario: Verify Copy Token button will give Bearer Token
    Given I enter with "admin" credentials
    And I click "Sign In" button
    When I click "Copy Token" button
    Then I verify Token is available


  @AddNewroleAndDelete
  Scenario: I add new role and delete the existing one
    Given I enter with "admin" credentials
    And I click "Sign in" button
    Then I create new:
      | role       |
    Then I delete the existing one

  @MarinaNewEmployeeAdminPage
  Scenario:I input new employee from role and departmend field
    Given I go to Admin page
    And I enter  the new Role Tester  then  I click the add button
    Then I enter Department Role and I click add button

  @Delete_Dep/Role
  Scenario:If any role or department is assigned to an employee I should not be able to delete it.
    Given I enter with "admin" credentials
    Then I click "Sign in" button
    And  I verify Delete role and department in case if it's assigned
  @Delete_Dep/Role
  Scenario:If any role or department is assigned to an employee I should not be able to delete it.
    Given I enter with "admin" credentials
    When I click "Sign in" button
    Then I create new:
      | role       |
      | department |
    And I fill out User Form "all fields" and click Enter Employee button
      | ID                |
      | First Name        |
      | Last Name         |
      | Select role       |
      | Select department |
    Then  I verify Delete role and department in case if it's assigned








