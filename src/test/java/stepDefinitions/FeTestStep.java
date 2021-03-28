package stepDefinitions;

import com.sun.xml.bind.v2.TODO;
import helpers.WebDriverBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FeTestStep extends WebDriverBase {

    WebDriver driver;

    //TODO: Do similar cucumber Hook instead
//    @AfterClass
//    public void afterClass(){
//        closeDriver();
//    }


    @Given("webdriver")
    public void webdriver() {
        driver = getDriver();

    }

    @When("webdriver opens windGuru")
    public void webdriver_opens_windGuru() {
        driver.get("https://www.windguru.cz/");
    }

    @Then("searchbox is displayed")
    public void searchbox_is_displayed() {
        WebElement searchBox = driver.findElement(By.id("searchspot"));
        boolean searchIsDisplayed = searchBox.isDisplayed();
        Assert.assertTrue("Search box not displayed", searchIsDisplayed);
        closeDriver();

    }
}
