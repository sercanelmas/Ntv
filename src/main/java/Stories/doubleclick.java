package Stories;

import static Utils.Definitions.*;
import Utils.Admin_Driver;

import Elements.Story_Btn;
import Utils.Definitions;
import org.junit.After;
import org.openqa.selenium.interactions.Actions;

public class doubleclick extends Admin_Driver {

    @After

    public void test() {

        Definitions.navigateTo("http://admin-preprod.ntv.com.tr/Story/List");
        navigateTo(stagingadmin);
        WaitAndClick(userName);
        Get_userName().sendKeys("sercan.elmas@dygdigital.com");
        Get_password().sendKeys("saSA''=(13");
        Get_loginButton().click();
        Actions action = new Actions(Definitions.driver);
        action.doubleClick(Story_Btn.Get_btn_HaberOlustur()).perform();

    }
}
