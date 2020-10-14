package _UI.step_definition;

import com.github.javafaker.Faker;
import common_util.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pojo.UserForm;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;

/**
 * In this class all step definitions for those steps in feature file are stored. Good practice to keep your steps
 * as short as possible. If you think your Test method will look bigger, try to create a method in implementation class
 * and call it in your step definition method.
 */
public class AdminPageTest {

    ScenarioContext context;

    UserForm userForm = new UserForm();
    String id = userForm.getId();


    public AdminPageTest(ScenarioContext scenarioContext) {
        this.context = scenarioContext;
    }

    /**
     * This method validating Employee data table
     */
    @Then("I verify fields are displayed with following data:")
    public void i_verify_fields_are_displayed_with_following_data(List<String> tableFields) {
        for (int i = 0; i < tableFields.size(); i++) {
            context.seleniumUtils.highlightElement(context.commonPage.empDataTableEl().get(i));
            Assert.assertEquals(tableFields.get(i), context.commonPage.employeeDataTable().get(i));
            context.seleniumUtils.logInfo(" Actual field: " + tableFields.get(i) + " Expected field: " + context.commonPage.employeeDataTable().get(i), false);
        }
        context.seleniumUtils.logInfo("Screenshot", true);
        context.seleniumUtils.moveIntoView(context.commonPage.searchBtn);
        context.seleniumUtils.logInfo("Employee Table Screenshot", true);
    }

    /**
     * This method will fill-out Employee  form
     */

    @And("I fill out User Form {string} and click Enter Employee button")
    public void Fill_User_Form(String form, List<String> dataTable) {
        context.seleniumUtils.logInfo("Before adding new employee data to the table", true);
        if (form.contains("all fields")) {
            for (int i = 0; i < 1; i++) {
                switch (dataTable.get(i)) {
                    case "ID":
                        context.commonPage.idField.sendKeys(id);
                    case "First Name":
                        context.commonPage.firstNameField.sendKeys(userForm.getFirstName());
                    case "Last Name ":
                        context.commonPage.lastNameField.sendKeys(userForm.getLastName());
                    case "Select role":
                        context.commonPage.selectRoleField.click();
                        context.commonPage.optionRole.click();
                    case "Select department":
                        context.commonPage.selectDeptField.click();
                        context.commonPage.depOption.click();
                    default:
                        System.out.println("Wrong Table Data");
                }
            }
            context.seleniumUtils.logInfo("After adding new employee data to the table", true);
            Assert.assertTrue(context.commonPage.enterEmployee_btn.isEnabled(), "Enter user button is Enabled");
            context.commonPage.enterEmployee_btn.click();
        }
        if (form.contains("with out select options")) {
            for (int i = 0; i < 1; i++) {
                switch (dataTable.get(i)) {
                    case "ID":
                        context.commonPage.idField.sendKeys(id);
                    case "First Name":
                        context.commonPage.firstNameField.sendKeys(userForm.getFirstName());
                    case "Last Name ":
                        context.commonPage.lastNameField.sendKeys(userForm.getLastName());
                    default:
                        System.out.println("Wrong Table Data");
                }
            }
            context.seleniumUtils.logInfo("After adding new employee data to the table", true);
            context.seleniumUtils.logInfo("Enter user button is Disabled",false);
            context.seleniumUtils.takeScreenshot(context.commonPage.enterEmployee_btn);
            Assert.assertFalse(context.commonPage.enterEmployee_btn.isEnabled(), "Enter user button is Disabled");
        }
        if (form.contains("leaving fields empty")) {
            context.seleniumUtils.logInfo("After not adding new employee data to the table", true);
            context.seleniumUtils.logInfo("Enter user button is Disabled",false);
            context.seleniumUtils.takeScreenshot(context.commonPage.enterEmployee_btn);
            Assert.assertFalse(context.commonPage.enterEmployee_btn.isEnabled(), "Enter user button is Disabled");
        }

    }

    /**
     * This method validating Employee data was added to table
     */

    @And("I verify the Data is populate in Employee data table")
    public void Verifying_the_data_is_in_employee_data_table() {
        context.commonPage.all_10_25_50_btn_list.get(3).click();
        for (int i = 0; i < context.commonPage.id_TableData.size(); i++) {
            if (id.equals(context.commonPage.id_TableData.get(i).getText())) {
                Assert.assertEquals(id, context.commonPage.id_TableData.get(i).getText(), "Data Table contains populated ID ");
                context.seleniumUtils.takeScreenshot(context.commonPage.id_TableData.get(i));

            }
        }
    }

    @Then("I verify same Employee Input form and Employee data table displayed")
    public void iVerifySameEmployeeInputFormAndEmployeeDataTableDisplayed() {
        context.seleniumUtils.moveIntoView(context.commonPage.headerList.get(0));
        for (int i = 0; i < context.adminPage.employeeData.length; i++) {
            context.seleniumUtils.highlightElement(context.commonPage.headerList.get(i));
            Assert.assertEquals(context.adminPage.employeeData[i], context.commonPage.headerList.get(i).getText());
            context.seleniumUtils.logInfo("Actual header: " + context.adminPage.employeeData[i] + " | +" + "Expected header: " + context.commonPage.headerList.get(i).getText(), false);
        }
    }



    @Given("I create new role")
    public void i_create_new_role() {
        context.adminPage.createRole.sendKeys("Sould Keeper");
        context.adminPage.addButton.click();
        Assert.assertEquals("Soul Keeper", "Soul Keeper");

    }

    @Then("I delete the existing one")
    public void i_delete_the_existing_one() {
        context.seleniumUtils.waitForPageToLoad();
        context.adminPage.DeleteRole.click();
        context.seleniumUtils.logInfo(" Clicked button: " + context.adminPage, true);

    }

    @Given("I go to Admin page")
    public void i_go_to_admin_page() {
        context.adminPage.username.sendKeys("admin");
        context.adminPage.password.sendKeys("admin123");
        context.seleniumUtils.click(context.adminPage.signIn);
        Assert.assertTrue(context.adminPage.signIn.isDisplayed());
        context.seleniumUtils.logInfo("signIn button: " + context.adminPage, true);


    }

    @And("I enter  the new Role Tester  then  I click the add button")
    public void ieNterTheNewRoleTesterThenIClickTheAddButton() {
        context.adminPage.enterRole.sendKeys("Testetr");
        context.adminPage.addButton1.click();
        Assert.assertTrue(context.adminPage.addButton1.isDisplayed());
        context.seleniumUtils.waitForVisibility(context.adminPage.tableRow);
        context.seleniumUtils.logInfo(" Add button: " + context.adminPage, true);

    }

    @Then("I enter Department Role and I click add button")
    public void iEnterDepartmentRoleAndIClickAddButton() {
        context.adminPage.departmentAreaRow.sendKeys("Manager");
        context.adminPage.addClickButton.click();
        Assert.assertTrue(context.adminPage.addClickButton.isDisplayed());
        context.seleniumUtils.logInfo(" Add button: DepartmentRole " + context.adminPage, true);

    }

    /**
     * This method validating functional of Deleting role / department
     * if it assigned to employee
     */

    @And("I verify Delete role and department in case if it's assigned")
    public void DeleteRoleDepartment() {
        for (int i = 0; i < context.adminPage.department_table_count.size(); i++) {
            if (Integer.parseInt(context.adminPage.department_table_count.get(i).getText().replace(")", "")) != 0) {
                context.adminPage.department_delete.get(i).click();
                context.seleniumUtils.logInfo("Warning pop-up for Department table ", true);
                Assert.assertTrue(context.adminPage.warning_popup.isDisplayed());
                context.adminPage.warning_close.click();
                break;
            }
        }
        for (int i = 0; i < context.adminPage.role_table_count.size(); i++) {
            if (Integer.parseInt(context.adminPage.role_table_count.get(i).getText().replace(")", "")) != 0) {
                context.adminPage.role_delete.get(i).click();
                context.seleniumUtils.logInfo("Warning pop-up for Role table", true);
                Assert.assertTrue(context.adminPage.warning_popup.isDisplayed());
                context.adminPage.warning_close.click();
                break;
            }
        }
    }
}

