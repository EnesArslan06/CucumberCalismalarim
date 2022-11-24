package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HeroquappPages {
    public HeroquappPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[text()='Add Element']")
    public WebElement addElementi;

    @FindBy (xpath = "//button[@onclick='deleteElement()']")
    public WebElement deleteElementi;

    @FindBy (xpath = "//*[text()='Dropdown']")
    public WebElement dropDown;

    @FindBy (xpath = "//select[@id='dropdown']")
    public WebElement dropDownElement;
}
