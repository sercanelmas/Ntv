package Infinity_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.NTV_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.extent;
import static Utils.Definitions.retryScroll;

public class Infinity_Scroll_Sanat extends NTV_Driver {
    ExtentTest logger;

    @After
    public void infinity_Scroll_Sanat() throws InterruptedException, IOException {
        logger = extent.startTest("Infinity Scroll Sanat");
        Get_catSanat().click();
        Get_catSanatContent().click();
        if (driver.getCurrentUrl().contains("/video/")) {
            navigateTo("https://www.ntv.com.tr/sanat/cingene-kizinin-parcalarigorucuye-cikiyor,GA_S-SpX4kCxM__vykVNFg");
        }
        retryScroll(logger);
    }
}

