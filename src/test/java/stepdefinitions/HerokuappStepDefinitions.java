package stepdefinitions;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HeroquappPages;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class HerokuappStepDefinitions {

    HeroquappPages heroquapp=new HeroquappPages();


    @Given("kullanici {string} sayfasina gider")
    public void kullanici_sayfasina_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("HerokuappAddElementUrl"));

    }
    @When("Add Element butonuna basar")
    public void add_element_butonuna_basar() {
            heroquapp.addElementi.click();
    }
    @Then("Delete butonu gorununceye kadar bekler")
    public void delete_butonu_gorununceye_kadar_bekler() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(heroquapp.deleteElementi));

    }
    @Then("Delete butonunun gorundgunu test eder")
    public void delete_butonunun_gorundgunu_test_eder() {
       Assert.assertTrue(heroquapp.deleteElementi.isDisplayed());
    }
    @Then("Delete butonuna basarak butonu siler")
    public void delete_butonuna_basarak_butonu_siler() {
       heroquapp.deleteElementi.click();
    }
    @Then("{int} saniye bekler")
    public void saniye_bekler(int sure) throws InterruptedException {
       Thread.sleep(sure*1000);
    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
       Driver.closeDriver();
    }

    @Given("kullanici Herokuapp sayfasina gider")
    public void kullanici_herokuapp_sayfasina_gider() {
      Driver.getDriver().get(ConfigReader.getProperty("Herokuapp"));
    }
    @Then("Dropdown butonuna tiklar")
    public void dropdown_butonuna_tiklar() {
        heroquapp.dropDown.click();
    }
    @Then("Butun secenekleri ekrana yazdirir")
    public void butun_secenekleri_ekrana_yazdirir() {
        Select select = new Select(heroquapp.dropDownElement);
        List<WebElement> elementler=select.getOptions();
        for (WebElement element : elementler) {
            System.out.println("element.getText() = " + element.getText());
        }
    }
    @Then("Option1 secenegini secer")
    public void option1_secenegini_secer() throws InterruptedException {
        Select select = new Select(heroquapp.dropDownElement);
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);
    }

}
