package popupwindows;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntryAd;

public class EntryAdTests extends BaseTests {

    @Test
    public void testModalWindowClose() throws InterruptedException {
        EntryAd page = homepage.clickEntryAd();
        page.closeModalWindow();
        Assert.assertEquals(page.showTextH3(), "Entry Ad", "Ok");
        //When modal window is open, we can get them as usual elements on a page, but we can't touch any others
    }
}
