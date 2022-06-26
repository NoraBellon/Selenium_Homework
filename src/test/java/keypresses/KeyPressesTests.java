package keypresses;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends BaseTests{
   //private String ourString =

    @Test
    public void checkInputKeys(){
        var keyPressPage = homepage.clickKeyPresses();
        //String h = "UOOPRT";
      //  keyPressPage.inputKey(h);
       // String check = keyPressPage.showInput();
      //  Assert.assertEquals("You entered: "+ h.substring(h.length()-1), check,"Work");
        keyPressPage.inputKey("N" + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressPage.showInput(), "You entered: BACK_SPACE");
    }
}
