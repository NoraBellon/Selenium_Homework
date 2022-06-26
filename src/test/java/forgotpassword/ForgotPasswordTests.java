package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ChangePassword;
import pages.ForgotPassoword;
import static org.testng.Assert.assertEquals;
public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testIfPasswordSend(){
        ForgotPassoword page = homepage.clickForgotPassword();
        page.inputEmail("valeriia.zhoian@nure.ua");
        ChangePassword nextpage = page.sendEmail();
        assertEquals(nextpage.getMessage(), "Internal Server Error", "It isn`t my bad that this server doesn`t work");
    }
}
