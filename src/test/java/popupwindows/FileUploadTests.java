package popupwindows;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        FileUploadPage page = homepage.clickFileUpload();
        page.uploadFile("C:\\Users\\user\\Desktop\\ISTBQ\\15.png");
        Assert.assertEquals(page.name(),"15.png", "fail smth");
    }
}
