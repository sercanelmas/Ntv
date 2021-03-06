package Auto_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;

import java.io.IOException;
import java.util.ArrayList;

import static Elements.Auto_Scroll_Elements.*;
import static Utils.Definitions.*;

public class Koc extends NTV_Driver {
    ExtentTest logger;
    int second = 0;

    @After
    public void Koc_Auto_Scroll() throws InterruptedException, IOException {
        logger = extent.startTest("Koç Burcu");
        jsExecuter(Get_astrolojiDiv(), "arguments[0].scrollIntoView(true);");
        Get_kocBurcu().click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        while (true) {
            if (driver.getTitle().contains("- 2 | NTV")) {
                logger.log(LogStatus.PASS, "Koç Burcuna Auto Scroll Yapıldı");
                driver.close();
                break;
            } else {
                second++;
                if (second == 10) {
                    logger.log(LogStatus.FAIL, "Koç Burcuna Auto Scroll Yapılamadı: " + logger.addScreenCapture(capture()));
                }
            }
            Thread.sleep(1000);
        }
    }
}
