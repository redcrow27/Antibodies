package _UI.pages;

import com.github.javafaker.service.FakeValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;
import java.util.List;

/**
 * All WebElements, also known as page objects of Admin Page are stored in this class. Page Factory is used to initialize
 * our objects so we can use them.
 */
public class AdminPage {


    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /**
     * Example creating element
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

    //Marina
    @FindBy(id = "inputArea1")
    public WebElement enterRole;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div[1]/form/button")
    public WebElement addButton1;

    @FindBy(id = "inputArea2")
    public WebElement departmentAreaRow;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/form/button")
    public WebElement addClickButton;

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/form/button")
    public WebElement signIn;

    @FindBy(css = "div.RoleClass")
    public WebElement tableRow;


    // **********************

    @FindBy(xpath = "//div[@class='dep']//tr/td/span")
    public List<WebElement> department_table_count;
    @FindBy(xpath = "//button[@class='btn btn-primary roleDelete']")
    public List<WebElement> role_delete;

    @FindBy(xpath = "//div[1]/div[2]/div/div[1]//tr/td/span")
    public List<WebElement> role_table_count;
    @FindBy(xpath = "//div[@class='dep']//button[@class='btn btn-primary ml-2 roleDelete']")
    public List<WebElement> department_delete;

    @FindBy(xpath = "//*[@id='myModal']/div/div/h3")
    public WebElement warning_popup;
    @FindBy(xpath = "//*[@id='myModal']/div/div/h3")
    public WebElement wrpop;

    @FindBy(id = "submit-btn")
    public WebElement warning_close;

    //**********************************


}

