package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassoword {
    WebDriver driver;
    private By emailField = By.id("email");
    private By submitButton = By.id("form_submit");

    public ForgotPassoword(WebDriver driver){
        this.driver = driver;
    }
    public void inputEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public ChangePassword sendEmail(){
        driver.findElement(submitButton).click();
        return new ChangePassword(driver);
    }
}
