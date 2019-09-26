package Sticky_Controls;

import Utils.Definitions;
import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static Elements.Logos.Get_ntvParaOnly;
import static Elements.Logos.Get_ntvParaOrj;

public class NTV_Para_Logo extends NTV_Driver {
    ExtentTest logger;

    @After
    public void NTV_Para_Logo() throws IOException, InterruptedException {
        logger = Definitions.extent.startTest("NTV Para Logo Testi");

        URL ntvParaLogoURL = new URL("https://cdn2.ntv.com.tr/content/img/external/ntvpara-logo-black3.png");
        HttpURLConnection connectionHeader = (HttpURLConnection) ntvParaLogoURL.openConnection();
        connectionHeader.setRequestMethod("GET");
        connectionHeader.connect();
        int codeHeader = connectionHeader.getResponseCode();
        if (codeHeader == 200) {
            logger.log(LogStatus.PASS, "NTV Para Header Logosu Gösteriliyor");
        } else {
            logger.log(LogStatus.FAIL, "NTV Para Header Logosu Gösterilemiyor");
        }
        URL ntvParaStickyLogoURL = new URL("https://cdn2.ntv.com.tr/content/img/external/ntvpara-logo-paraonly3.png");
        HttpURLConnection connectionSticky = (HttpURLConnection) ntvParaStickyLogoURL.openConnection();
        connectionSticky.setRequestMethod("GET");
        connectionSticky.connect();
        int codeSticky = connectionSticky.getResponseCode();
        if (codeSticky == 200) {
            logger.log(LogStatus.PASS, "NTV Para Sticky Header Logosu Gösteriliyor");
        } else {
            logger.log(LogStatus.FAIL, "NTV Para Sticky Header Logosu Gösterilemiyor");
        }
        Definitions.Scroll(500);
        if (Get_ntvParaOrj().isEnabled() == true) {
            logger.log(LogStatus.PASS, "Header Sticky Görünüme Geçtiğinde Logo Değiştiriliyor");
        } else {
            logger.log(LogStatus.FAIL, "Header Sticky Görünüme Geçtiğinde Logo Değiştirilemiyor");
        }

        Definitions.Scroll(-500);
        if (Get_ntvParaOnly().isEnabled() == true) {
            logger.log(LogStatus.PASS, "Header Sticky Görünümden Çıktığında Logo Değiştiriliyor");
        } else {
            logger.log(LogStatus.FAIL, "Header Sticky Görünümden Çıktığında Logo Değiştirilemiyor");
        }

    }
}
