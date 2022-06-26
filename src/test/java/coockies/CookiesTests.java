package coockies;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiesTests extends BaseTests {

    @Test
    public void testDeletingCookie(){
        String cookie = "optimizelyBuckets";
        deleteCookies(cookie);
        for (String n : showNamesOfCookies()) {
           Assert.assertNotEquals(n,cookie);
        }
    }
}
