package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    //1.private By formAuthenticationLink = By.linkText("Form Authentication");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink(){
        //1.driver.findElement(formAuthenticationLink).click();
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public ForgotPassoword clickForgotPassword(){
        clickLink("Forgot Password");
        return new ForgotPassoword(driver);
    }

    public HoversPage clickHoversPage(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }
    public KeyPressPage clickKeyPresses(){
        clickLink("Key Presses");
        return  new KeyPressPage(driver);
    }
    public HorizontalSlider clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return  new HorizontalSlider(driver);
    }
    public JavaScriptAlertsPage clickJavaScriptsAlertsPage(){
        clickLink("JavaScript Alerts");
        return new JavaScriptAlertsPage(driver);
    }
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }
    public ContextMenu clickContextMenu(){
        clickLink("Context Menu");
        return new ContextMenu(driver);
    }
    public EntryAd clickEntryAd(){
        clickLink("Entry Ad");
        return new EntryAd(driver);
    }
    public WYSIWYGEditor clickWYSIWYGEditor(){
        clickLink("WYSIWYG Editor");
        return new WYSIWYGEditor(driver);
    }
    public DymanicLoadingPage clickDymanicLoading(){
       // clickLink("Dymanic Loading");
        By link = By.xpath("//*[@id=\"content\"]/ul/li[14]/a");
        driver.findElement(link).click();
        return new DymanicLoadingPage(driver);
    }
    public LargeDeepDOMPage clickLargeDeepDom(){
        clickLink("Large & Deep DOM");
        return new LargeDeepDOMPage(driver);
    }

    private void clickLink(String linkText){

        driver.findElement(By.linkText(linkText)).click();
    }
    //there is no webdriver element method to implements "hover over this"
    // but there is an additional class in selenium webdriver package

}
