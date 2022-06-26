package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class KeyPressPage {
    private WebDriver driver;
    private By inputTargert = By.id("target");
    private By result = By.id("result");



    public KeyPressPage(WebDriver driver){
        this.driver = driver;

    }

    public void inputKey( String yourInput){
        driver.findElement(inputTargert).sendKeys(yourInput);
     }

    public String showInput(){
        return driver.findElement(result).getText();
    }


}
