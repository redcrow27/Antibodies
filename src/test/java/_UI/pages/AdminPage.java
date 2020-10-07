package _UI.pages;

import com.github.javafaker.service.FakeValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All WebElements, also known as page objects of Admin Page are stored in this class. Page Factory is used to initialize
 * our objects so we can use them.
 */
public class AdminPage {



    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**
     *  Example creating element
     */
    @FindBy(id = "valueOfId")
    public WebElement sampleElement;

    @FindBy(xpath = "//table[@class='table']/thead")
    public WebElement adminTable;

   public String[] employeeData = {"ID", "First", "Last", "Role", "Department"};

   @FindBy(xpath = "//button[text()='Copy Token']")
    public WebElement copyTokenBtn;

   @FindBy(xpath = "//form/input[@id='inputArea1']")
    public WebElement createRole;

   @FindBy(xpath = "//*[contains(text(),'Add')]")
    public WebElement addButton;

   @FindBy(xpath = "//button[@class='btn btn-primary roleDelete']")
    public WebElement DeleteRole;
}
