package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

public class LargeDeepDOMTest extends BaseTests {

    @Test
    public void testScrollTable(){
        homepage.clickLargeDeepDom().scrollToTable();
    }
}
