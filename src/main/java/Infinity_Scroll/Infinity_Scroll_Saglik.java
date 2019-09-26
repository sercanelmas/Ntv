package Infinity_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.NTV_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.extent;
import static Utils.Definitions.retryScroll;

public class Infinity_Scroll_Saglik extends NTV_Driver {
    ExtentTest logger;


    @After
    public void infinity_Scroll_Saglik() throws InterruptedException, IOException {
        logger = extent.startTest("Infinity Scroll Sağlık");
        Get_catSaglik().click();
        Get_catSaglikContent().click();
        if (driver.getCurrentUrl().contains("/video/")) {
            navigateTo("https://www.ntv.com.tr/saglik/reyno-raynaud-fenomeni-soguk-havalari-seviyor,fc8Y1oWvR0qJa-ifQPQxzQ");
        }
        retryScroll(logger);
    }
}
