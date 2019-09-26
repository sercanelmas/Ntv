package Photo_Galleries;

import Elements.PG_Btn;
import Elements.PG_Elements;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import Utils.Admin_Driver;

import java.util.concurrent.TimeUnit;

import static Elements.PG_Btn.*;
import static Elements.PG_Elements.*;
import static Utils.Definitions.*;
import static java.lang.Thread.*;

public class PG_Save_and_Without_Updating_Publish extends Admin_Driver {

    ExtentTest logger;

    @After // Var olan bir galeride değişiklik yaparak kaydeder ve listeye döner
    public void photo_gallery_save() throws InterruptedException {
        logger = extent.startTest("Foto Galeri - Kaydet ve Güncelleme Tarihini Güncellemeden Yayınla");
        Get_btnPhotoGalleries().click();
        String galleryTitle = Get_PG_listTitle().getText();
        Get_btnPhotoGalleryList().click();

        Get_btnPG_ImageSearch().click();
        WaitAndClick(PG_ImageSearch);
        sleep(500);
        ClickAndSend(PG_Title, mainTitle);

        ClickAndSend(PG_ShortTitle, mainTitle);

        WebElement PGSpot = Get_PG_Spot();
        randomElementForTextGenerator(PGSpot, 30);

        PG_Elements.Get_PG_Category().click();
        sleep(2000);
        Get_PG_CategprySelect().click();

        WaitAndClick(btn_continue);

        sleep(3000);

        photoUpload();

        PG_Btn.Get_PG_btnSaveDropdown().click();
        sleep(1000);
        PG_Btn.Get_PG_btnSavePublish().click();
        sleep(60000);
        Get_PG_btnSaveDropdown().click();
        sleep(1000);
        Get_PG_btnsaveAndDontUpdateTimelineTime().click();
        String url = Get_PG_btnBrowse().getAttribute("href");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        try {
            navigateTo(url);
            if (driver.getTitle().equals(mainTitle + " - 1 | NTV") &&
                    !checkElement(PG_lastUpdateCss)) {
                logger.log(LogStatus.PASS, galleryTitle + " Adlı Galeri Güncellendi ve Güncellenme Tarihi Yayınlanmadan Yayına Alındı");
            } else {
                logger.log(LogStatus.FAIL, galleryTitle + "Adlı Galerinin Güncelleme Tarihi veya Başlığı Sorunlu");
            }

        } catch (TimeoutException e) {
            logger.log(LogStatus.SKIP, "TimeOut Sorunu");
        }
    }

    @AfterTest
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, "sercan fail-0 Failed is " + result.getName());
            logger.log(LogStatus.FAIL, "sercan fail-1 Failed is " + result.getThrowable());
            logger.log(LogStatus.INFO, "test info" + result.toString());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "sercan Pass " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Skip TimeOut Sex" + result.getName());
        }
        extent.endTest(logger);
    }
}

