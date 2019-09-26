package Cookie_Policy;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;

import static Elements.Cookie_Policy.*;
import static Utils.Definitions.*;
import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;
import static java.lang.Thread.sleep;

public class Cookie_Policy extends NTV_Driver {

    ExtentTest logger;

    @After
    public void cookiePolicy() throws InterruptedException, IOException {
        logger = extent.startTest("ntv.com.tr - Çerez Politikası Testi");
        runCookiePolicyProcedure();
    }

    private void runCookiePolicyProcedure() throws InterruptedException, IOException {
        if (checkElement(ntvCookiePolicy)) {
            logger.log(PASS, "Çerez Politikasını Okumamış Kullanıcıya Ana Sayfada Çerez Politikası Popup'ı Gösteriliyor");
            checkCookiePolicy();
        } else {
            logger.log(FAIL, "Çerez Politikası Bandı Gösterilmiyor: " + logger.addScreenCapture(capture()));
        }
    }

    private void checkCookiePolicy() throws InterruptedException, IOException {
        navigateTo("https://www.ntv.com.tr/turkiye");
        if (!checkElement(ntvCookiePolicy)) {
            logger.log(PASS, "Ana Sayfa Haricinde Çerez Politikası Popup'ı Gösterilmiyor");
            reCheckCookiePolicy();
        } else {
            logger.log(FAIL, "Ana Sayfa Haricinde Çerez Politikası Popup'ı Gösteriliyor: " + logger.addScreenCapture(capture()));
        }
    }

    private void reCheckCookiePolicy() throws InterruptedException, IOException {
        navigateTo(ntv);
        if (checkElement(ntvCookiePolicy)) {
            ntvCookiePolicyDetail();
        } else {
            logger.log(FAIL, "Kullanıcı Okudum Butonuna Basmadığı Halde Çerez Politikası Bandı Gösterilmiyor: " + logger.addScreenCapture(capture()));
        }
    }

    private void ntvCookiePolicyDetail() throws InterruptedException, IOException {
        WaitAndClick(ntvCookiePolicyDetail);
        if (driver.getTitle().equals("Çerez Politikası | NTV")) {
            logger.log(PASS, "Çerez Politikası Detay Linki Başarılı Şekilde Yönlendirme Yapıyor");
            ntvCookiePolicyReadBtn();
        } else {
            logger.log(FAIL, "Çerez Politikası Sayfası Açılmıyor: " + logger.addScreenCapture(capture()));
        }
    }

    private void ntvCookiePolicyReadBtn() throws InterruptedException, IOException {
        navigateTo(ntv);
        WaitAndClick(ntvBtnCookiePolicyRead);
        sleep(2000);
        if (Get_ntvCookiePolicy().isDisplayed() == false) {
            logger.log(PASS, "Çerez Politikası Okudum Butonu Sorunsuz Çalışıyor");

            noNtvCookiePolicy();
        } else {
            logger.log(FAIL, "Çerez Politikası Okudum Butonu Çalışmıyor: " + logger.addScreenCapture(capture()));
        }
    }

    private void noNtvCookiePolicy() throws IOException {
        driver.navigate().refresh();
        if (Get_ntvCookiePolicy().isDisplayed() == false) {
            logger.log(PASS, "Çerez Politikası Okudum Butonuna Tıklayan Kullanıcıya Popup Bir Daha Gösterilmiyor");
        } else {
            logger.log(FAIL, "Çerez Politikası Kabul Edilmesine Rağmen Kullanıcıya Tekrar Gösteriliyor: " + logger.addScreenCapture(capture()));
        }
        extent.endTest(logger);

    }
}

