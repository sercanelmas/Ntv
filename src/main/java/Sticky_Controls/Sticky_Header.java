package Sticky_Controls;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.Logos.Get_header;
import static Elements.Logos.Get_headerClass;
import static Utils.Definitions.*;
import static com.relevantcodes.extentreports.LogStatus.*;

public class Sticky_Header extends NTV_Driver {
    ExtentTest logger;

    @After
    public void Sticky_Header () throws IOException {
        logger = extent.startTest("Sticky_Header");
        if(Get_header().getAttribute("class").equals("sticky-wrapper") &&
                Get_headerClass().getAttribute("style").equals("z-index: 2000;")) {
            scrollDownAndUp();
        }else {
            logger.log(WARNING, "Sayfa, Aşağı Scroll Edilmiş Olarak Yükleniyor");
            Scroll(-1000);
            scrollDownAndUp();
        }
    }

    private void scrollDownAndUp () throws IOException {
        Scroll(2000);
        if(Get_header().getAttribute("class").equals("sticky-wrapper is-sticky") &&
        Get_headerClass().getAttribute("style").equals("z-index: 2000; width: 1519px; position: fixed; top: 0px;")) {
            logger.log(PASS, "Sticky Header Sorunsuz Şekilde Çalışıyor - Scroll Down");
            scrollUp();
        } else {
            String screenShot_1 = logger.addScreenCapture(capture());
            logger.log(FAIL, "Sticky Header Beklenen Şekilde Çalışmıyor" + logger.addScreenCapture(capture()));
        }
    }

    private void scrollUp () throws IOException {
        Scroll(-2000);
        if(Get_header().getAttribute("class").equals("sticky-wrapper") &&
                Get_headerClass().getAttribute("style").equals("z-index: 2000;")) {
            logger.log(PASS, "Sticky Header Sorunsuz Şekilde Çalışıyor - Scroll Up");
        } else {
            String screenShot_1 = logger.addScreenCapture(capture());
            logger.log(FAIL, "Sticky Header Beklenen Şekilde Çalışmıyor" + logger.addScreenCapture(capture()));
        }
    }
}
