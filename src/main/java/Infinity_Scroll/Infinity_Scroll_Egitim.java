package Infinity_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.NTV_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.extent;
import static Utils.Definitions.retryScroll;

public class Infinity_Scroll_Egitim extends NTV_Driver {
    ExtentTest logger;

    @After
    public void infinity_Scroll_Egitim() throws InterruptedException, IOException {
        logger = extent.startTest("Infinity Scroll Eğitim");
        Get_catEgitim().click();
        Get_catTurkiyeContent().click();
        if (driver.getCurrentUrl().contains("/video/")) {
            navigateTo("https://www.ntv.com.tr/egitim/2018-dgsde-94-bin-426-kisi-sifir-cekti,9UTgj_fUa0i1f98xJ5j8XA");
        }
        retryScroll(logger);
    }
}
