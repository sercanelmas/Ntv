package Sticky_Controls;

import Utils.Definitions;
import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import static Elements.Logos.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class NTV_Spor_Logo extends NTV_Driver {
    ExtentTest logger;

    @After
    public void NTV_Spor_Logo() throws IOException {
        logger = Definitions.extent.startTest("NTV Spor Logo Testi");

        String ntvSporLogo = Get_ntvSporLogo().getCssValue("background-image");
        URL ntvSporLogoURL = new URL("https://cdn2.ntv.com.tr/content/img/external/ntvspor-logo.png");
        HttpURLConnection connectionHeader = (HttpURLConnection) ntvSporLogoURL.openConnection();
        connectionHeader.setRequestMethod("GET");
        connectionHeader.connect();
        int codeHeader = connectionHeader.getResponseCode();
        if (codeHeader == 200) {
            logger.log(LogStatus.PASS, "NTV Spor Header Logosu Gösteriliyor");
        } else {
            logger.log(LogStatus.FAIL, "NTV Spor Header Logosu Gösterilemiyor");
        }
        URL ntvsporStickyLogoURL = new URL("https://cdn2.ntv.com.tr/content/img/external/ntvspor-logo-sporonly.png");
        HttpURLConnection connectionSticky = (HttpURLConnection) ntvsporStickyLogoURL.openConnection();
        connectionSticky.setRequestMethod("GET");
        connectionSticky.connect();
        int codeSticky = connectionSticky.getResponseCode();
        if (codeSticky == 200) {
            logger.log(LogStatus.PASS, "NTV Spor Sticky Header Logosu Gösteriliyor");
        } else {
            logger.log(LogStatus.FAIL, "NTV Spor Sticky Header Logosu Gösterilemiyor");
        }
        Definitions.Scroll(500);
        String ntvSporStickyLogo = Get_ntvSporLogo().getCssValue("background-image");
        if (ntvSporLogo != ntvSporStickyLogo) {
            logger.log(LogStatus.PASS, "Header Sticky Görünüme Geçtiğinde Logo Değiştiriliyor");
        }else{
            logger.log(LogStatus.FAIL, "Header Sticky Görünüme Geçtiğinde Logo Değiştirilemiyor");
        }

        Definitions.Scroll(-500);
        if (ntvSporLogo != ntvSporStickyLogo) {
            logger.log(LogStatus.PASS, "Header Sticky Görünümden Çıktığında Logo Değiştiriliyor");

        }else{
            logger.log(LogStatus.FAIL, "Header Sticky Görünümden Çıktığında Logo Değiştirilemiyor");
        }
    }
}
