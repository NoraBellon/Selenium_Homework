package hovers;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversTests extends BaseTests {

    @Test
    public void testHoverUser1(){
       var hoversPage = homepage.clickHoversPage();
       var  caption = hoversPage.hoverOverFigure(1);
       assertTrue(caption.isCaptionDisplayed(), "Caption isn`t displayed");
       assertEquals(caption.getTitle(), "name: user1", "Caption title is incorrect");
       assertEquals(caption.getLinkText(), "View profile", "Caption link text is incorrect");
       assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");
    }
}
