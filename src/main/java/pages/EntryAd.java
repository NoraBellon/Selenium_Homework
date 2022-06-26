package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntryAd {
    private WebDriver driver;
  //  private By clickHere = By.id("restart-ad");
  //  private By popUpWindow = By.id("content");
    private By modalFooter = By.className("modal-footer");
    private By close = By.tagName("p");
    private By afterClose = By.tagName("h3");

    public EntryAd(WebDriver driver){
        this.driver = driver;
    }

    public void closeModalWindow() throws InterruptedException {
        WebElement footer = driver.findElement(modalFooter);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalFooter));
        Actions action = new Actions(driver);
        //Thread.sleep(2000);
        action.moveToElement(footer).perform();
    }
    public String showTextH3(){
        return driver.findElement(afterClose).getText();
    }


}
