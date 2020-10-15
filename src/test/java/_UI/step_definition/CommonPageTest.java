package _UI.step_definition;

import _UI.pages.CommonPage;
import common_util.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Here you will store all those steps that can be used in any pages and doesnt belong to any of them
 */
public class CommonPageTest {
    ScenarioContext context;

    public String bearerToken;

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
                context.seleniumUtils.sendKeys(context.commonPage.usernameField, username.toLowerCase());
                context.seleniumUtils.sendKeys(context.commonPage.passwordField, adminPassword);
                context.seleniumUtils.logInfo(" Entered Username: " + username + " Entered Password: " + adminPassword, false);
                break;
            case "user":
                context.seleniumUtils.sendKeys(context.commonPage.usernameField, username.toLowerCase());
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
            case "copy token":
                context.seleniumUtils.moveIntoView(context.adminPage.copyTokenBtn);
                context.seleniumUtils.click(context.adminPage.copyTokenBtn);
                bearerToken = context.seleniumUtils.getClipboardData();
                context.seleniumUtils.takeScreenshot(context.adminPage.copyTokenBtn);
                break;
            case "search":
                context.seleniumUtils.click(context.commonPage.searchBtn);
                break;
            case "add department":
                context.seleniumUtils.moveIntoView(context.adminPage.addClickButton);
                context.seleniumUtils.click(context.adminPage.addClickButton);
                break;
            case "delete btn in department table":
                context.seleniumUtils.moveIntoView(context.adminPage.department_delete.get(0));
                context.seleniumUtils.click(context.adminPage.department_delete.get(0));
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
        WebElement element;
        for (String s : buttons) {
            switch (s) {
                case "10 users":
                    element = context.commonPage.all_10_25_50_btn_list.get(0);
                    element.click();
                    context.seleniumUtils.logInfo("When I select : " + s, false);
                    context.seleniumUtils.takeScreenshot(element);
                    Assert.assertTrue(Integer.parseInt(element.getText()) >= context.commonPage.id_TableData.size());
                    context.seleniumUtils.logInfo("Expected 10 users;  " + "Actual result is: " + context.commonPage.id_TableData.size(), false);
                    break;
                case "25 users":
                    element = context.commonPage.all_10_25_50_btn_list.get(1);
                    element.click();
                    context.seleniumUtils.logInfo("When I select : " + s, false);
                    context.seleniumUtils.takeScreenshot(element);
                    Assert.assertTrue(Integer.parseInt(element.getText()) >= context.commonPage.id_TableData.size());
                    context.seleniumUtils.logInfo("Expected 25 users;  " + "Actual result is: " + context.commonPage.id_TableData.size(), false);
                    break;
                case "50 users":
                    element = context.commonPage.all_10_25_50_btn_list.get(2);
                    element.click();
                    context.seleniumUtils.logInfo("When I select : " + s, false);
                    context.seleniumUtils.takeScreenshot(element);
                    Assert.assertTrue(Integer.parseInt(element.getText()) >= context.commonPage.id_TableData.size());
                    context.seleniumUtils.logInfo("Expected 50 users;  " + "Actual result is: " + context.commonPage.id_TableData.size(), false);
                    break;
                case "All users":
                    element = context.commonPage.all_10_25_50_btn_list.get(3);
                    element.click();
                    context.seleniumUtils.logInfo("When I select : " + s, false);
                    context.seleniumUtils.takeScreenshot(element);
                    if (context.commonPage.id_TableData.size() >= 50) {
                        Assert.assertTrue(Integer.parseInt(context.commonPage.all_10_25_50_btn_list.get(2).getText()) <= context.commonPage.id_TableData.size());
                        context.seleniumUtils.logInfo("Expected 50 or more users;  " + "Actual result is: " + context.commonPage.id_TableData.size(), false);
                    }
                    break;
                default:
                    System.out.println("Wrong button");
            }
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
        context.seleniumUtils.logInfo("Screenshot", true);
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
                Assert.assertFalse(context.commonPage.submitBtn.isEnabled(), "Enter user button is Disabled");
                context.seleniumUtils.takeScreenshot(context.commonPage.submitBtn);
                break;
            default:
                System.out.println("INVALID BUTTON");
        }

    }


    @Then("I enter {string} keyword in Filter field")
    public void iEnterKeywordInFilterField(String keyword) {
        context.seleniumUtils.moveIntoView(context.commonPage.filterField);
        context.seleniumUtils.sendKeys(context.commonPage.filterField, keyword);
        context.seleniumUtils.logInfo(" I enter keyword: " + keyword, true);
    }

    @Then("I verify {string} keyword in {string} Employee data table")
    public void iVerifyKeywordInEmployeeDataTable(String keyword, String page) {
        switch (page.toLowerCase()) {
            case "admin page":
                String expected = context.commonPage.adminPageThirdTable.findElement(By.xpath("//*[text()='" + keyword + "']")).getText();
                Assert.assertEquals(keyword, expected);
                context.seleniumUtils.logInfo(" Keyword match on Employee table : " + expected, true);
                break;
            case "user page":
                String expected2 = context.commonPage.userPageTable.findElement(By.xpath("//*[text()='" + keyword + "']")).getText();
                Assert.assertEquals(keyword, expected2);
                context.seleniumUtils.logInfo(" Entered keyword: " + keyword + " Expected keyword: " + expected2, true);
                break;
            default:
                System.out.println("Invalid page");
        }

    }


    @Then("I verify Token is available")
    public void iVerifyTokenIsAvailable() {
        context.seleniumUtils.logInfo("Bearer token: " + bearerToken, false);
    }


    @And("I verify {string} button is enabled")
    public void iVerifyButtonIsEnabled(String button) {
        switch (button.toLowerCase()) {
            case "sign in":
                context.seleniumUtils.highlightElement(context.commonPage.submitBtn);
                Assert.assertTrue(context.commonPage.submitBtn.isDisplayed());
                context.seleniumUtils.logInfo(context.commonPage.submitBtn.getText() + " button is displayed", true);
                Assert.assertTrue(context.commonPage.submitBtn.isEnabled(), "Enter user button is Enabled");
                context.seleniumUtils.takeScreenshot(context.commonPage.submitBtn);
                break;
            default:
                System.out.println("INVALID BUTTON");
        }
    }

}
