package popupwindows;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WYSIWYGEditor;

public class WYSIWYGEditorTests extends BaseTests {

    @Test
    public void testTextArea() throws InterruptedException {
        WYSIWYGEditor page = homepage.clickWYSIWYGEditor();
        page.cleanEditArea();
        page.setItalicFormat();
        page.inputInTextArea("I will" );
        Assert.assertEquals(page.readFromTextArea(),"I will");
    }
}
