package Utils;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static Utils.Definitions.*;

import static Utils.Definitions.driver;
import static Utils.Definitions.extent;

public class NTV_Driver {

    @Before
    public void setUp() {
        driverSettings();
    }

    @Test
    public void ntvcomtr() {
        navigateTo("https://www.ntv.com.tr");
    }
    public String homePage = "https://www.ntv.com.tr";

    @After
    public void endReport(){
        extent.flush();
        driver.quit();
    }
}
