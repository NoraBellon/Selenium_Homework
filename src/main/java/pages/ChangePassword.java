package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword {
    private WebDriver driver;
    private By statusofChanging = By.tagName("h1");

    public ChangePassword(WebDriver driver){
        this.driver = driver;
    }
    public String getMessage(){
        return driver.findElement(statusofChanging).getText();
    }
}
