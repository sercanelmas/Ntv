package Photo_Galleries;

import static Elements.PG_Btn.*;

import Elements.PG_Elements;
import Utils.Admin_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import static Elements.PG_Elements.*;

import java.util.ArrayList;

import static Utils.Definitions.*;
import static java.lang.Thread.*;

public class Photo_Gallery_Save_and_Publish extends Admin_Driver {
    ExtentTest logger;

    @After
    public void photo_gallery_save() throws InterruptedException {
        logger = extent.startTest("Foto Galeri - Kaydet ve Yayınla");
        Get_btnPhotoGalleries().click();
        Get_btnPhotoGalleryList().click();

        Get_btnPG_ImageSearch().click();
        WaitAndClick(PG_ImageSearch);
        sleep(500);
        ClickAndSend(PG_Title, mainTitle);

        ClickAndSend(PG_ShortTitle, mainTitle);

        WebElement PGSpot = Get_PG_Spot();
        randomElementForTextGenerator(PGSpot, 30);

        Get_PG_Category().click();
        sleep(2000);
        Get_PG_CategprySelect().click();

        WaitAndClick(btn_continue);

        sleep(3000);

        PG_Elements.photoUpload();

        WebElement saveAndPublish = Get_PG_btnSaveDropdown();
        jsExecuter(saveAndPublish, "arguments[0].scrollIntoView(true);");
        sleep(1000);
        Get_PG_btnSaveDropdown().click();
        sleep(1000);
        Get_PG_btnSavePublish().click();
        sleep(1000);
        String url = Get_PG_btnBrowse().getAttribute("href");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        try {
            navigateTo(url);
            if (driver.getTitle().equals(mainTitle + " - 1 | NTV")) {
                driver.switchTo().window(tabs.get(0));
                navigateTo("http://admin-staging.ntv.com.tr/PhotoGallery/List");
                String storyTitle = Get_PG_listTitle().getText();
                if (Get_PG_listTitle().getText().equals(mainTitle) &&
                        Get_PG_listStatus().getText().equals("Yayında")) {
                }
                logger.log(LogStatus.PASS, storyTitle + " Adlı Galeri Kaydedildi ve Yayınlandı");
                //System.out.println("Foto Galeri Kaydedildi ve Yayınlandı");
            } else {
                logger.log(LogStatus.FAIL, "Foto Galeri Kaydedilemedi");
                //System.out.println("Galeri Kaydedilemedi");
            }
        }catch (TimeoutException e) {
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