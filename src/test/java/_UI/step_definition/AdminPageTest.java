package _UI.step_definition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pojo.UserForm;

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


    public AdminPageTest(ScenarioContext scenarioContext){
        this.context = scenarioContext;
    }

    /**
     * This method validating Employee data table
     */
    @Then("I verify fields are displayed with following data:")
    public void i_verify_fields_are_displayed_with_following_data(List<String> tableFields) {
        for (int i = 0; i < tableFields.size(); i++) {
            context.seleniumUtils.highlightElement(context.commonPage.empDataTableEl().get(i));
            Assert.assertEquals(tableFields.get(i), context.commonPage.employeeDataTable().get(i) );
            context.seleniumUtils.logInfo(" Actual field: " + tableFields.get(i) + " Expected field: " + context.commonPage.employeeDataTable().get(i) , false);
        }
        context.seleniumUtils.logInfo("Screenshot" , true);
    }

    /**
     * This method will fill-out Employee  form
     */

    @And("I fill out User Form  and click Enter Employee button")
    public void Fill_User_Form(List<String> dataTable) {

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
        context.commonPage.enterEmployee_btn.click();

        context.seleniumUtils.logInfo("Screenshot" , true);
    }

    /**
     * This method validating Employee data was added to table
     */

    @And("I verify the Data is populate in Employee data table")
    public void Verifying_the_data_is_in_employee_data_table() {
        for (int i = 0; i < context.commonPage.id_TableData.size(); i++) {
            if (id.equals(context.commonPage.id_TableData.get(i).getText())) {
                Assert.assertEquals(id, context.commonPage.id_TableData.get(i).getText(), "Data Table contains populated ID ");
            }
        }
        context.seleniumUtils.logInfo("Screenshot" , true);
    }

    @Then("I verify same Employee Input form and Employee data table displayed")
    public void iVerifySameEmployeeInputFormAndEmployeeDataTableDisplayed() {

        context.seleniumUtils.moveIntoView(context.commonPage.headerList.get(0));
        for(int i = 0; i < context.adminPage.employeeData.length; i++) {
            context.seleniumUtils.highlightElement(context.commonPage.headerList.get(i));
            Assert.assertEquals(context.adminPage.employeeData[i], context.commonPage.headerList.get(i).getText());
            context.seleniumUtils.logInfo("Actual header: " + context.adminPage.employeeData[i] + " | +" + "Expected header: " + context.commonPage.headerList.get(i).getText(), false);
        }
    }
}
