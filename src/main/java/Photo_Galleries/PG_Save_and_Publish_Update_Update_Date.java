package Photo_Galleries;

import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import Utils.Admin_Driver;


import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static Elements.PG_Btn.*;
import static Elements.PG_Elements.*;
import static Utils.Definitions.*;
import static Utils.Definitions.mainTitle;
import static java.lang.Thread.sleep;

public class PG_Save_and_Publish_Update_Update_Date extends Admin_Driver {
    ExtentTest logger;

    @After // Var olan bir galeride değişiklik yaparak kaydeder ve listeye döner
    public void photo_gallery_save() throws InterruptedException {
        logger = extent.startTest("Foto Galeri - Kaydet Yayınla ve Yayınlanma Tarihini Güncelle");
        Get_btnPhotoGalleries().click();
        if (Get_PG_listStatus().getText().equals("Yeni")) {
            String galleryTitle = Get_PG_listTitle().getText();

            Get_PG_listTitle().click();
            Wait(PG_Title);
            WebElement areaTitle = Get_PG_Title();
            areaTitle.clear();
            areaTitle.sendKeys(mainTitle);

            WebElement saveAndPublish = Get_PG_btnSaveDropdown();
            jsExecuter(saveAndPublish, "arguments[0].scrollIntoView(true);");
            sleep(1000);
            Get_PG_btnSaveDropdown().click();
            sleep(1000);
            Get_PG_btnSavePublish().click();
            sleep(60000);
            Get_PG_btnSaveDropdown().click();
            sleep(1000);
            Get_PG_btnSaveAndUpdateTimelineTime().click();

            Definitions.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            String url = Get_PG_btnBrowse().getAttribute("href");
            System.out.println(url);

            try {
                navigateTo(url);
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
                String date1 = format1.format(calendar.getTime());

                if (Definitions.driver.getTitle().equals(mainTitle + " - 1 | NTV") &&
                        checkElement(PG_lastUpdateCss) &&
                        Get_PG_lastUpdateCss().getText().equals("Son Güncelleme : " + date1)) {
                    logger.log(LogStatus.PASS, galleryTitle + " Adlı Galeri Kaydedildi Yayınlandı ve Yayınlanma Tarihi Güncellendi");
                } else {
                    logger.log(LogStatus.FAIL, galleryTitle + " Adlı Galerinin Güncelleme Tarihi Hatalı");
                }
            } catch (TimeoutException e) {
                logger.log(LogStatus.SKIP, "TimeOut Sorunu");
            }
        } else if (Get_PG_listStatus().getText().equals("Yayında Değil")) {
            WebElement btn_listpublish = Get_PG_btnListPublis();
            btn_listpublish.click();
            while (true) {
                if (Get_PG_listStatus().getText().equals("Yayında")) {
                    Job();
                    break;
                }
                sleep(1000);
            }
        } else {
            Job();
        }
    }

    private void Job() throws InterruptedException {
        String galleryTitle = Get_PG_listTitle().getText();

        Get_PG_listTitle().click();
        Wait(PG_Title);
        WebElement areaTitle = Get_PG_Title();
        areaTitle.clear();
        areaTitle.sendKeys(mainTitle);

        WebElement saveAndPublish = Get_PG_btnSaveDropdown();
        jsExecuter(saveAndPublish, "arguments[0].scrollIntoView(true);");
        sleep(1000);
        Get_PG_btnSaveDropdown().click();
        sleep(1000);
        Get_PG_btnSaveAndUpdateTimelineTime().click();
        sleep(3000);

        Definitions.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        String url = Get_PG_btnBrowse().getAttribute("href");
        System.out.println(url);

        try {
            navigateTo(url);
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
            String date1 = format1.format(calendar.getTime());

            if (Definitions.driver.getTitle().equals(mainTitle + " - 1 | NTV") &&
                    checkElement(PG_lastUpdateCss) &&
                    Get_PG_lastUpdateCss().getText().equals("Son Güncelleme : " + date1)) {
                logger.log(LogStatus.PASS, galleryTitle + " Adlı Galeri Kaydedildi Yayınlandı ve Yayınlanma Tarihi Güncellendi");
            } else {
                logger.log(LogStatus.FAIL, galleryTitle + " Adlı Galerinin Güncelleme Tarihi Hatalı");
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
            extent.endTest(logger);
        }
    }
}
