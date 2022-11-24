package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AutomationExcercisePages;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class AutomationExerciseTC01StepDefinitions2 {
    AutomationExcercisePages autoPages=new AutomationExcercisePages();

    @Then("Verify that home page is visible successfully check")
    public void verify_that_home_page_is_visible_successfully_check() {
        Assert.assertTrue(autoPages.girisKontrol.isDisplayed());
    }
    @Then("Click on Signup - Login button")
    public void clickOnSignupLoginButton() {

        autoPages.login.click();
        ReusableMethods.waitFor(1);
    }

    @Then("Verify Login to your account is visible")
    public void verify_login_to_your_account_is_visible() {
        Assert.assertTrue(autoPages.loginKontrol.isDisplayed());
    }
    @Then("Enter correct email address and password")
    public void enter_correct_email_address_and_password() {
        autoPages.emailGiris.sendKeys(ConfigReader.getProperty("kullaniciEmail"));
        ReusableMethods.waitFor(1);
        autoPages.passWordGiris.sendKeys(ConfigReader.getProperty("sifre"));
        ReusableMethods.waitFor(1);

    }
    @Then("Click login button")
    public void click_login_button() {
        autoPages.loginButton.click();
    }
    @Then("Verify that Logged in as username is visible check")
    public void verify_that_logged_in_as_username_is_visible_check() {
        Assert.assertTrue(autoPages.nameControl.getText().contains("Enes"));
        ReusableMethods.waitFor(1);
    }




}
