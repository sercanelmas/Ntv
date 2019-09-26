package Infinity_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.NTV_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.extent;
import static Utils.Definitions.retryScroll;

public class Infinity_Scroll_Teknoloji extends NTV_Driver {
    ExtentTest logger;

    @After
    public void infinity_Scroll_Teknoloji() throws InterruptedException, IOException {
        logger = extent.startTest("Infinity Scroll Teknoloji");
        Get_catTeknoloji().click();
        Get_catTeknolojiContent().click();
        if (driver.getCurrentUrl().contains("/video/")) {
            navigateTo("https://www.ntv.com.tr/teknoloji/bilim-olumu-yenebilecek-mi-daniel-zajfman-ntv-com-trnin-sorularini-yanitladi,VzvsfikidEKQM5J9bDgelA");
        }
        retryScroll(logger);
    }
}
