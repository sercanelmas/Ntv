package Infinity_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.NTV_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.extent;
import static Utils.Definitions.retryScroll;

public class Infinity_Scroll_Yasam extends NTV_Driver {
    ExtentTest logger;

    @After
    public void infinity_Scroll_Yasam() throws InterruptedException, IOException {
        logger = extent.startTest("Infinity Scroll Yaşam");
        Get_catYasam().click();
        Get_catYasamContent().click();
        if (driver.getCurrentUrl().contains("/video/")) {
            navigateTo("https://www.ntv.com.tr/yasam/zubizu-alisveris-gunleri-bu-yil-200un-uzerinde-marka-ve-tasarimciyi-agirlayacak,Q3Mix3lryUmaELKKGJFcuA");
        }
        retryScroll(logger);
    }
}
