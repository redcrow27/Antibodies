package _UI.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * All WebElements, also known as page objects of Common Page are stored in this class. Page Factory is used to initialize
 * our objects so we can use them.
 */
public class CommonPage {

    public CommonPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    /**
     *  Example creating element
     */
    @FindBy(id = "valueOfId")
    public WebElement sampleElement;

    /**
     *  I added most of Common Elements here because we will use in all pages
     */

    @FindBy(name = "username")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(tagName = "button")
    public WebElement submitBtn;

    @FindBy(name = "id")
    public WebElement idField;

    @FindBy(name = "firstName")
    public WebElement firstNameField;

    @FindBy(name = "lastName")
    public WebElement lastNameField;

    @FindBy(xpath = "//*[text()='Select role']")
    public WebElement selectRoleField;

    @FindBy(xpath = "//*[text()='Select department']")
    public WebElement selectDeptField;

    @FindBy(xpath = "//form/select/option[7]")
    public WebElement depOption;

    @FindBy(xpath = "//td/select/option[3]")
    public WebElement optionRole;

    @FindBy(xpath = "//*[text()='Enter Employee']")
    public WebElement enterEmployee_btn;

    @FindBy(xpath = "//*[@class='btn-sm btn-info m-2']")
    public List<WebElement> all_10_25_50_btn_list;

    @FindBy(xpath = "//th[@scope='row']")
    public List<WebElement> id_TableData;

    @FindBy(xpath = "(//table)[1]//tr/td")
    public List<WebElement> roleTableList;

    @FindBy(xpath = "((//table)[3]//tr)[2]/td[3]")
    public WebElement firstRoleResult;

    @FindBy(xpath = "//input[@name='keyword']")
    public WebElement filterField;

    @FindBy(xpath = "//button[text()='Search']")
    public WebElement searchBtn;

    @FindBy(xpath = "(//table)[3]")
    public WebElement adminPageThirdTable;

    @FindBy(xpath = "//table")
    public WebElement userPageTable;


    /**
     * This method is not get any paramaters but
     * @return will return list of Employee data table names as a String
     */
    public List<String> employeeDataTable() {
        List<String> list = new ArrayList<>();
        list.add(idField.getAttribute("placeholder"));
        list.add(firstNameField.getAttribute("placeholder"));
        list.add(lastNameField.getAttribute("placeholder"));
        list.add(selectRoleField.getText());
        list.add(selectDeptField.getText());
        return list;
    }

    /**
     * This method is not get any paramaters but
     * @return will return list of Employee data table names as a WebElement
     */
    public List<WebElement> empDataTableEl() {
        List<WebElement> list = new ArrayList<>();
        list.add(idField);
        list.add(firstNameField);
        list.add(lastNameField);
        list.add(selectRoleField);
        list.add(selectDeptField);
        return list;
    }

}
