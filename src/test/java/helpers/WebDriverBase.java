package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBase {

    WebDriver driver = null;


    public WebDriver getDriver(WebDriver driver) {
        if(driver == null){
            driver = new ChromeDriver();
        }
        return driver;
    }
}
