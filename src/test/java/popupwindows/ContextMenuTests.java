package popupwindows;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenu;


public class ContextMenuTests extends BaseTests {

    @Test
   public void verifyTextInAlert() throws InterruptedException {
        ContextMenu page = homepage.clickContextMenu();

        Assert.assertEquals(page.getTextFromAlert(), "You selected a context menu", "You selected a context menu");


    }
}
