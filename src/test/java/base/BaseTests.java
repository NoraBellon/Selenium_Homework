package base;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import util.EventReporter;
import util.WindowManager;

import java.util.HashSet;
import java.util.Set;

import java.io.File;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.openqa.selenium.By.linkText;


public class BaseTests {
    private EventFiringWebDriver driver;
    protected HomePage homepage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new EventFiringWebDriver (new ChromeDriver(getChromeOptions()));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.register(new EventReporter());
       // driver.manage().timeouts().pageLoadTimeout().setScriptTimeout()
        goHomePage();
        setCookies();
    }

    @BeforeMethod
    public void goHomePage(){
        driver.get("https://the-internet.herokuapp.com/");
        homepage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        //driver.close() - close just a window, not the session
        //quit() - close any of windows opened during this session
    }
    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE == result.getStatus()){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        // System.out.println("Screenshot taken:" + screenshot.getAbsolutePath());
        Files.move(screenshot, new File("src/screenshots/" + result.getName() + ".png"));
        }
    }
//    @AfterMethod
//    public void takeScreenshot() throws IOException {
//        var camera = (TakesScreenshot)driver;
//        File screenshot = camera.getScreenshotAs(OutputType.FILE);
//       // System.out.println("Screenshot taken:" + screenshot.getAbsolutePath());
//        Files.move(screenshot, new File("src/screenshots/test.png"));
//    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }
    private void setCookies(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
    //Delete one of these cookies, maybe this first one called optimizelyBuckets,
    // and then verify that this cookie does not exist anymore.
    public void deleteCookies(String cookiesName){
        driver.manage().deleteCookieNamed("optimizelyBuckets");
    }
    public Set<Cookie> getAllCookies(){
        return driver.manage().getCookies();
    }
    public Set<String> showNamesOfCookies(){
        Set<String> names = new HashSet<>();
        getAllCookies().stream().forEach(a -> names.add(a.getName()));
        return  names;
    }

}
