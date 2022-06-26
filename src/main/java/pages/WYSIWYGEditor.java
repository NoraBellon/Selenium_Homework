package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WYSIWYGEditor {
    private WebDriver driver;
  /*  private By fileButton = By.xpath("//button[position() = 1]");
            //By.xpath("//div[@role='menubar']/button[position() = 1]");
    private By editButton = By.xpath("//button[position() = 2]");
    private By viewButton = By.xpath("//button[position() = 3]");
    private By formatButton = By.xpath("//button[position() = 4]");*/
    private String editorIFrame = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By italicFormat = By.xpath("//div[@title='Italic']");
    private By formatButton = By.xpath("//button[position() = 4]");


    public WYSIWYGEditor(WebDriver driver){
        this.driver = driver;
    }
    public void cleanEditArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public void setItalicFormat(){
        driver.findElement(formatButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.findElement(italicFormat).click();
    }
    public void inputInTextArea(String text) throws InterruptedException {
        switchToEditArea();
        Thread.sleep(2000);
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public String readFromTextArea() throws InterruptedException {
        switchToEditArea();
        Thread.sleep(2000);
        String str = driver.findElement(textArea).getText();
        switchToMainArea();
        return str;
    }


    private void switchToEditArea(){
        driver.switchTo().frame(editorIFrame);
    }
    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
