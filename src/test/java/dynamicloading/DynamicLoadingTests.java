package dynamicloading;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;
import pages.DymanicLoadingPage;

public class DynamicLoadingTests extends BaseTests {

    @Test
    public void testWaitUntilHidden() throws InterruptedException {

        DymanicLoadingPage.DynamicLoading1Page page = homepage.clickDymanicLoading().clickLinkExample1();
        page.clickStartButton();
        Assert.assertEquals(page.getLoadedText(), "Hello World!");

    }
}
