package Infinity_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.NTV_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.extent;
import static Utils.Definitions.retryScroll;

public class Infinity_Scroll_Turkiye extends NTV_Driver {
    ExtentTest logger;

    @After
    public void infinity_Scroll_Turkiye() throws InterruptedException, IOException {
        logger = extent.startTest("Infinity Scroll Turkiye");
        Get_catTurkiye().click();
        Get_catTurkiyeContent().click();
        if (driver.getCurrentUrl().contains("/video/")) {
            navigateTo("https://www.ntv.com.tr/turkiye/kulce-altin-diye-parke-tasi-sattilar,yzqVtPQv7EKDRd56TOMdrw");
        }
        retryScroll(logger);
    }
}
