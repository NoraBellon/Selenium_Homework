package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    private WebDriver driver;
    private By jsAlert = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    private By jsConfirm = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
    private By jsPrompt = By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
    private By result = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver){
        this.driver = driver;
    }
   public String getResultText(){
        return driver.findElement(result).getText();
   }
    public void clickjsAlert(){
       driver.findElement(jsAlert).click();
    }
    public void acceptAllert() {
       // Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }
    public void clickjsConfirm(){
        driver.findElement(jsConfirm).click();
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
    public void clickjsPrompt(){
        driver.findElement(jsPrompt).click();
    }
    public void enterTextInAlert(String str){
        driver.switchTo().alert().sendKeys(str);
    }


}
