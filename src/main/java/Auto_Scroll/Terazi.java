package Auto_Scroll;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;

import java.io.IOException;
import java.util.ArrayList;

import static Elements.Auto_Scroll_Elements.*;
import static Utils.Definitions.*;

public class Terazi extends NTV_Driver {
    ExtentTest logger;
    int second = 0;

    @After
    public void Terazi_Auto_Scroll() throws InterruptedException, IOException {
        logger = extent.startTest("Terazi Burcu");
        jsExecuter(Get_astrolojiDiv(), "arguments[0].scrollIntoView(true);");
        Get_teraziBurcu().click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        while (true) {
            if (driver.getTitle().contains("- 8 | NTV")) {
                logger.log(LogStatus.PASS, "Terazi Burcuna Auto Scroll Yapıldı");
                driver.close();
                break;
            } else {
                second++;
                if (second == 10) {
                    logger.log(LogStatus.FAIL, "Terazi Burcuna Auto Scroll Yapılamadı: " + logger.addScreenCapture(capture()));
                }
            }
            Thread.sleep(1000);
        }
    }
}