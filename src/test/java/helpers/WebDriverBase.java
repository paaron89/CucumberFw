package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBase {

   private WebDriver driver = null;


    public WebDriver getDriver() {
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void closeDriver(){
        driver.close();
    }
}
