package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DymanicLoadingPage {
    private WebDriver driver;
    private By linkExample1 = By.linkText("Example 1: Element on page that is hidden");
    private String linkXpathFormat = ".//a[contains(text(), '%s')";
   // private By linkExample1 = By.xpath(String.format(linkXpathFormat, "Example 1"));

    public DymanicLoadingPage(WebDriver driver){
        this.driver = driver;
    }
    public DynamicLoading1Page clickLinkExample1() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(linkExample1).click();
        return new DynamicLoading1Page(driver);
    }


    public class DynamicLoading1Page {
        private WebDriver driver;
        private By startButton = By.cssSelector("#start button");
        private By loading = By.id("loading");
        private By loadedText = By.id("finish");

        public DynamicLoading1Page(WebDriver driver){
            this.driver = driver;
        }
        public void clickStartButton(){
             driver.findElement(startButton).click();
            /* WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loading)));*/
            FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).
                    pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loading)));
        }
        public String getLoadedText(){
            return driver.findElement(loadedText).getText();
        }
    }
}
