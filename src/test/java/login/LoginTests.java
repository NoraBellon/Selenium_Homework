package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
    LoginPage loginPage = homepage.clickFormAuthenticationLink();
    loginPage.setUserName("tomsmith");
    loginPage.setPasswordField("SuperSecretPassword!");
    SecureAreaPage securePage = loginPage.clickLoginButton();
    //Thread.sleep(100);
    assertEquals(securePage.getAlertText(), "You logged into a secure area!\n" +
                    "×",
            "Alert text is incorrect!");
    // import static org.testng.Assert.*;
        //assertTrue(securePage.getAlertText().contains("You logged into a secure area!\n + ×"),
        //            "Alert text is incorrect!");

    }
}
