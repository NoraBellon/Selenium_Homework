package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By dragDropUpload = By.xpath("//*[@id=\"drag-drop-upload\"]");
    private By buttonUpload = By.id("file-submit");
    private By inputField = By.id("file-upload");
    private By uploadedFile = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    private void clickChooseFile(){
        driver.findElement(buttonUpload).click();
    }
    public void uploadFile(String fullPathToFile){
        driver.findElement(inputField).sendKeys(fullPathToFile);
        clickChooseFile();
    }
    public String name(){
        return driver.findElement(uploadedFile).getText();
    }

}
