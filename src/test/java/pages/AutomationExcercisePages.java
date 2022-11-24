package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExcercisePages {
    public AutomationExcercisePages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    public WebElement girisKontrol; 
    
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement login;

    @FindBy(xpath = "//*[text()='New User Signup!']")
    public WebElement NewUserKontrol;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement nameTextBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy(xpath = "//*[text()='Enter Account Information']")
    public WebElement girisSonrasiKOntrol;

    @FindBy(xpath = "(//div[@class='radio'])[1]")
    public WebElement radioButton;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//select[@data-qa='days']")
    public WebElement selectDays;

    @FindBy(xpath = "//select[@data-qa='months']")
    public WebElement selectMonths;

    @FindBy(xpath = "//select[@data-qa='years']")
    public WebElement selectYears;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement letter1;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement letter2;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement secondName;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreated;

    @FindBy(xpath = "(//a[@style='color:brown;'])[2]")
    public WebElement deleteElementi;

    @FindBy(xpath = "//*[text()='Account Deleted!']")
    public WebElement accountDeleted;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
    public WebElement nameControl;

    @FindBy(xpath= "//a[@class='btn btn-primary']")
    public WebElement continueButton2;

    @FindBy(xpath = "//*[text()='Login to your account']")
    public WebElement loginKontrol;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emailGiris;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passWordGiris;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

}
