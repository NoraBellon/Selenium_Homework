package horizontalslider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSlider;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void checkSliderRange() throws InterruptedException {
     HorizontalSlider horizontalSlider = homepage.clickHorizontalSlider();
     horizontalSlider.setFocusOnSlider();
    // horizontalSlider.move();
     horizontalSlider.equateSliderToRange();
     Assert.assertEquals(horizontalSlider.showRange(), "0.5");
    }
}
