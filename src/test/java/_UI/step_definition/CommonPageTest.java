package _UI.step_definition;

import common_util.ConfigReader;
import io.cucumber.java.en.Given;

/**
 * Here you will store all those steps that can be used in any pages and doesnt belong to any of them
 */
public class CommonPageTest {
    ScenarioContext context;

    public CommonPageTest(ScenarioContext scenarioContext) {
        this.context = scenarioContext;
    }


    /**
     * This method will open giving page URL
     * Rigth now will open Login Page
     * @param pageName Login Page
     */
    @Given("I open {string}")
    public void i_open(String pageName) {
        String loginPageURL =  ConfigReader.readProperty("url", "src/test/resources/properties/configuration.properties");
        switch (pageName.toLowerCase()) {
            case "login page": context.driver.get(loginPageURL);
                context.seleniumUtils.logInfo(" Entered URL: " + loginPageURL, false);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    /**
     * This method enter given login credentials
     * And will get the Password from configuration.properties
     * You just need to specify which Username
     * @param username admin , user
     */
    @Given("I enter with {string} credentials")
    public void i_enter_with_credentials(String username) {
        String adminPassword = ConfigReader.readProperty("admin", "src/test/resources/properties/configuration.properties");
        String userPassword = ConfigReader.readProperty("user", "src/test/resources/properties/configuration.properties");
        switch (username.toLowerCase()) {
            case "admin":
                context.seleniumUtils.sendKeys(context.commonPage.usernameField, username);
                context.seleniumUtils.sendKeys(context.commonPage.passwordField, adminPassword);
                context.seleniumUtils.logInfo(" Entered Username: " + username + " Entered Password: " + adminPassword, false);
                break;
            case "user":
                context.seleniumUtils.sendKeys(context.commonPage.usernameField, username);
                context.seleniumUtils.sendKeys(context.commonPage.passwordField, userPassword);
                context.seleniumUtils.logInfo(" Entered Username: " + username + " Entered Password: " + userPassword, false);
                break;
            default:
                System.out.println("Invalid credentials");
        }

    }

    /**
     * This method will click given button
     * Please follow same format
     * @param button will take a String button name
     */
    @Given("I click {string} button")
    public void i_click_button(String button) {
        switch (button.toLowerCase()) {
            case "sign in":
                context.seleniumUtils.click(context.commonPage.submitBtn);
                break;
            default:
                System.out.println("Invalid button name: " + button);
        }
        context.seleniumUtils.logInfo(" Clicked button: " + button, false);
    }






}
