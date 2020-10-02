package _UI.step_definition;

import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

/**
 * In this class all step definitions for those steps in feature file are stored. Good practice to keep your steps
 * as short as possible. If you think your Test method will look bigger, try to create a method in implementation class
 * and call it in your step definition method.
 */
public class AdminPageTest {

    ScenarioContext context;

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
}
