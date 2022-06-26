package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class HorizontalSlider {
    private WebDriver driver;
    private By input = By.tagName("input");;
    private By range = By.xpath("//input[@type='range']");
    private By numberRange = By.id("range");


    public HorizontalSlider(WebDriver driver){
        this.driver = driver;
    }
     public void setFocusOnSlider() throws InterruptedException {
       // Thread.sleep(5000);
        driver.findElement(range).click();
     }
     public void move(){
        driver.findElement(range).sendKeys(Keys.RIGHT);
     }
     public String showRange(){
        return driver.findElement(numberRange).getText();
    }
    public void equateSliderToRange(){
        Double n = 2*Double.parseDouble(showRange());
        for (double i = 8.0; i == n; i--){
            move();
        }
    }

}
