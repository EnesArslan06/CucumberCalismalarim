package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AutomationExcercisePages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class AutomationExerciseTC01StepDefinitions {
    Select select,select2, select3;
    AutomationExcercisePages autoPages=new AutomationExcercisePages();
    Faker faker=new Faker();
    Actions act;
    String name=faker.name().fullName();

    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("AutomationExercise"));
    }
    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        Assert.assertTrue(autoPages.girisKontrol.isDisplayed());
        ReusableMethods.waitFor(2);
    }
    @Then("Click on {string} button")
    public void click_on_button(String string) {
       autoPages.login.click();
        ReusableMethods.waitFor(2);

    }
    @Then("Verify {string} is visible")
    public void verify_is_visible(String string) {
        Assert.assertTrue(autoPages.NewUserKontrol.isDisplayed());
        ReusableMethods.waitFor(2);
    }
    @Then("Enter name and email address")
    public void enter_name_and_email_address() {

       autoPages.nameTextBox.sendKeys(name);
       autoPages.emailTextBox.sendKeys(faker.internet().emailAddress());
       ReusableMethods.waitFor(2);
    }
    @Then("Click {string} button")
    public void click_button(String string) {
       autoPages.signupButton.click();
        ReusableMethods.waitFor(2);
    }
    @Then("Verify that {string} is visible")
    public void verify_that_is_visible(String string) {
       Assert.assertTrue(autoPages.girisSonrasiKOntrol.isDisplayed());
    }
    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        autoPages.radioButton.click();
        ReusableMethods.waitFor(2);
        //Assert.assertTrue(autoPages.radioButton.isSelected());
        autoPages.passwordTextBox.sendKeys(faker.internet().password(8,12,true));
        ReusableMethods.waitFor(2);
        select=new Select(autoPages.selectDays);
        select.selectByVisibleText("15");
        ReusableMethods.waitFor(2);
        select2=new Select(autoPages.selectMonths);
        select2.selectByVisibleText("July");
        ReusableMethods.waitFor(2);
        select3=new Select(autoPages.selectYears);
        select3.selectByVisibleText("2000");
        ReusableMethods.waitFor(2);

    }
    @Then("Select checkbox {string}")
    public void select_checkbox(String string) {
        autoPages.letter1.click();
        ReusableMethods.waitFor(2);
        autoPages.letter2.click();
        ReusableMethods.waitFor(2);
    }
    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
       autoPages.secondName.sendKeys(faker.name().firstName());
       ReusableMethods.waitFor(2);
        act=new Actions(Driver.getDriver());
        act.sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.job().field()).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city()).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB).sendKeys(faker.address().state()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().city()).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode())
                .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);
    }

    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        Assert.assertTrue(autoPages.accountCreated.isDisplayed());
        ReusableMethods.waitFor(2);

    }

    @And("Click Continue button")
    public void clickContinueButton() {
        autoPages.continueButton.click();

    }

    @And("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        autoPages.girisKontrol.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(autoPages.nameControl.getText().contains(name));

    }


    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
        autoPages.deleteElementi.click();
        ReusableMethods.waitFor(2);
    }

    @And("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        Assert.assertTrue(autoPages.accountDeleted.isDisplayed());
        ReusableMethods.waitFor(2);
        autoPages.continueButton2.click();
        System.out.println("name: "+name);
    }

    @And("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }
}
