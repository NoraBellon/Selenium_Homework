package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {
    private WebDriver driver;
    private By boxXpath = By.xpath("//*[@id=\"hot-spot\"]");

    public ContextMenu(WebDriver driver){
        this.driver = driver;
    }
    public void rightClickOnBox(){
        WebElement box = driver.findElement(boxXpath);
        Actions click = new Actions(driver);
        click.contextClick(box).perform();
    }
    public String getTextFromAlert() throws InterruptedException {
        rightClickOnBox();
        Thread.sleep(1000);
       String str = driver.switchTo().alert().getText();
        Thread.sleep(1000);
       acceptAlert();
       return  str;
       //You selected a context menu
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

}
