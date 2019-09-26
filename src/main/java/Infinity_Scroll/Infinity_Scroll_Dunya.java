package Infinity_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.NTV_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.extent;
import static Utils.Definitions.retryScroll;

public class Infinity_Scroll_Dunya extends NTV_Driver {
    ExtentTest logger;

    @After
    public void infinity_Scroll_Dunya() throws InterruptedException, IOException {
        logger = extent.startTest("Infinity Scroll Dunya");
        Get_catDunya().click();
        Get_catDunyaContent().click();
        if (driver.getCurrentUrl().contains("/video/")) {
            navigateTo("https://www.ntv.com.tr/dunya/kuzey-kore-gizli-fuze-ussu-insa-ediyor,X3MtRRcea0iBoPeWlNAISw");
        }
        retryScroll(logger);
    }
}
