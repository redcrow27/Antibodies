package _UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements, also known as page objects of User Page are stored in this class. Page Factory is used to initialize
 * our objects so we can use them.
 */
public class UserPage {

    public UserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**
     *  Example creating element
     */
    @FindBy(id = "valueOfId")
    public WebElement sampleElement;

    @FindBy(xpath = "//div/input[@name='username']")
    public WebElement userLoginButton;

    @FindBy(xpath = "//div/input[@type='password']")
    public WebElement userPasswordButton;

    @FindBy(xpath = "//form/button")
    public WebElement LogInButton;

    @FindBy(xpath = "//div/nav")
    public WebElement TextHeader;

}
