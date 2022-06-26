package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTests extends BaseTests {

    @Test
    public void testSelectOption(){
        var dropDownPage = homepage.clickDropDown();
        String option1 = "Option 1";
        dropDownPage.selectDropdown(option1);
       var selectedOptions = dropDownPage.getSelectedOption();
       assertEquals(selectedOptions.size(),1, "Incorrect number of selection");
       assertTrue(selectedOptions.contains(option1));
    }
}
