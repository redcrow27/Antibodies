package _UI.step_definition;

import _UI.pages.UserPage;
import common_util.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



/**
 * In this class all step definitions for those steps in feature file are stored. Good practice to keep your steps
 * as short as possible. If you think your Test method will look bigger, try to create a method in implementation class
 * and call it in your step definition method.
 */
public class UserPageTest {

    ScenarioContext context;
    ScenarioContext scenarioContext = new ScenarioContext();

    public UserPageTest(ScenarioContext scenarioContext){
        this.context = scenarioContext;
    }
    @Given("I enter  {string} and {string}")
    public void i_enter_and(String string, String string2) {
        String userPassword = ConfigReader.readProperty("user", "src/test/resources/properties/configuration.properties");
        context.userPage.userLoginButton.sendKeys("user");
        context.userPage.userPasswordButton.sendKeys("user123");


    }



    @And("I click Sign in button")
    public void i_click_sign_in_button() {
    context.userPage.LogInButton.click();
    }

    @Then("I verify headers are displayed with following data")
    public void i_verify_headers_are_displayed_with_following_data() {
    context.seleniumUtils.waitForPageToLoad();
    context.seleniumUtils.logInfo("Actual header: " + " | +" + "Expected header: " + context.userPage.TextHeader.getText(), true);



    }

}
