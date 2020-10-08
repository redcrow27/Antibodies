package _UI.step_definition;

import common_util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

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
     *
     * @param pageName Login Page
     */
    @Given("I open {string}")
    public void i_open(String pageName) {
        String loginPageURL = ConfigReader.readProperty("url", "src/test/resources/properties/configuration.properties");
        switch (pageName.toLowerCase()) {
            case "login page":
                context.driver.get(loginPageURL);
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
     *
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
     *
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
        Assert.assertEquals("", "");
    }


    /**
     * This method will click given button
     * To verify the buttons to limit display count are functional
     */

    @Then("I verify the buttons to limit display count are functional:")
    public void LimitDisplayCount_test(List<String> buttons) {
        for (String s : buttons) {
            switch (s) {
                case "10btn":
                    context.commonPage.all_10_25_50_btn_list.get(0).click();
                    Assert.assertTrue(Integer.parseInt(context.commonPage.all_10_25_50_btn_list.get(0).getText()) >= context.commonPage.id_TableData.size());
                    break;
                case "25btn":
                    context.commonPage.all_10_25_50_btn_list.get(1).click();
                    Assert.assertTrue(Integer.parseInt(context.commonPage.all_10_25_50_btn_list.get(1).getText()) >= context.commonPage.id_TableData.size());
                    break;
                case "50btn":
                    context.commonPage.all_10_25_50_btn_list.get(2).click();
                    Assert.assertTrue(Integer.parseInt(context.commonPage.all_10_25_50_btn_list.get(2).getText()) >= context.commonPage.id_TableData.size());
                    break;
                case "All_bnt":
                    context.commonPage.all_10_25_50_btn_list.get(3).click();
                    if (context.commonPage.id_TableData.size() >= 50) {
                        Assert.assertTrue(Integer.parseInt(context.commonPage.all_10_25_50_btn_list.get(2).getText()) <= context.commonPage.id_TableData.size());
                    }
                    break;
                default:
                    System.out.println("Wrong button");
            }
            context.seleniumUtils.logInfo("Clicked button: " + s, true);
        }
    }


    /**
     * This method will search any keyword
     *
     * @param keyword String keyword
     * @param page    String page name
     */
    @Then("I verify search for any employee based on any keyword such as {string} in {string} Employee data table")
    public void iVerifySearchForAnyEmployeeBasedOnAnyKeywordSuchAsInEmployeeDataTable(String keyword, String page) {
        switch (page.toLowerCase()) {
            case "admin page":
                context.seleniumUtils.moveIntoView(context.commonPage.filterField);
                context.seleniumUtils.sendKeys(context.commonPage.filterField, keyword);
                context.seleniumUtils.click(context.commonPage.searchBtn);
                context.seleniumUtils.sleep(2000);
                String expected = context.commonPage.adminPageThirdTable.findElement(By.xpath("//*[text()='" + keyword + "']")).getText();
                Assert.assertEquals(keyword, expected);
                context.seleniumUtils.logInfo(" Entered keyword: " + keyword + " Expected keyword: " + expected, false);
                break;
            case "user page":
                context.seleniumUtils.moveIntoView(context.commonPage.filterField);
                context.seleniumUtils.sendKeys(context.commonPage.filterField, keyword);
                context.seleniumUtils.click(context.commonPage.searchBtn);
                context.seleniumUtils.sleep(2000);
                String expected2 = context.commonPage.userPageTable.findElement(By.xpath("//*[text()='" + keyword + "']")).getText();
                Assert.assertEquals(keyword, expected2);
                context.seleniumUtils.logInfo(" Entered keyword: " + keyword + " Expected keyword: " + expected2, false);
                break;
            default:
                System.out.println("Invalid page");
        }
    }

    @Then("I verify headers are displayed with following data:")
    public void i_verify_headers_are_displayed_with_following_data(List<String> headerList) {
        context.seleniumUtils.moveIntoView(context.commonPage.headerList.get(0));
        for (int i = 0; i < headerList.size(); i++) {
            context.seleniumUtils.highlightElement(context.commonPage.headerList.get(i));
            Assert.assertEquals(headerList.get(i), context.commonPage.headerList.get(i).getText());
            context.seleniumUtils.logInfo("Actual header: " + headerList.get(i) + " | +" + "Expected header: " + context.commonPage.headerList.get(i).getText(), false);
        }
    }


    @Given("I verify {string} field is displayed")
    public void iVerifyFieldIsDisplayed(String field) {
        switch (field.toLowerCase()) {
            case "username":
                context.seleniumUtils.highlightElement(context.commonPage.usernameField);
                Assert.assertTrue(context.commonPage.usernameField.isDisplayed());
                context.seleniumUtils.logInfo(context.commonPage.usernameField.getText() + " field is displayed", true);
                break;
            case "password":
                context.seleniumUtils.highlightElement(context.commonPage.passwordField);
                Assert.assertTrue(context.commonPage.passwordField.isDisplayed());
                context.seleniumUtils.logInfo(context.commonPage.passwordField.getText() + " field is displayed", true);
                break;
            default:
                System.out.println("INVALID FIELD");
        }

    }

    @Then("I verify {string} button is displayed")
    public void iVerifyButtonIsDisplayed(String button) {
        switch (button.toLowerCase()) {
            case "sign in":
                context.seleniumUtils.highlightElement(context.commonPage.submitBtn);
                Assert.assertTrue(context.commonPage.submitBtn.isDisplayed());
                context.seleniumUtils.logInfo(context.commonPage.submitBtn.getText() + " button is displayed", true);
                break;
            default:
                System.out.println("INVALID BUTTON");
        }

    }
}
