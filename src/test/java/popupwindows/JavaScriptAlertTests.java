package popupwindows;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

public class JavaScriptAlertTests extends BaseTests {

    @Test
    public void testAlertAccept(){
       JavaScriptAlertsPage alertsWindows = homepage.clickJavaScriptsAlertsPage();
       alertsWindows.clickjsAlert();
       alertsWindows.acceptAllert();
       Assert.assertEquals(alertsWindows.getResultText(), "You successfully clicked an alert", "Result text is incorrect");
    }
    @Test
    public void testGetTextFromAlert(){
        JavaScriptAlertsPage alertsPage = homepage.clickJavaScriptsAlertsPage();
        alertsPage.clickjsConfirm();
        String text = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        Assert.assertEquals(text, "I am a JS Confirm", "Alert text is incorrect");
    }

    @Test
    public void testTextInputAlert(){
        JavaScriptAlertsPage alertsPage = homepage.clickJavaScriptsAlertsPage();
        alertsPage.clickjsPrompt();
        String str = "Valeriia";
        alertsPage.enterTextInAlert(str);
        alertsPage.acceptAllert();
        Assert.assertEquals("You entered: "+str, alertsPage.getResultText(), "crush");
    }

}
