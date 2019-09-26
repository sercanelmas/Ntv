package Photo_Galleries;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.After;
import Utils.Admin_Driver;

import org.openqa.selenium.WebElement;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import static Elements.PG_Btn.*;
import static Utils.Definitions.*;
import static java.lang.Thread.*;
import static Elements.PG_Elements.*;

public class PG_Unpublish extends Admin_Driver {
    ExtentTest logger;

    @After // Var olan bir galeride değişiklik yaparak kaydeder ve listeye döner
    public void photo_gallery_save() throws InterruptedException {
        logger = extent.startTest("Foto Galeri - Yayından Kaldır");
        Get_btnPhotoGalleries().click();
        if (Get_PG_listStatus().getText().equals("Yayında Değil")) {
            Get_PG_btnListPublis().click();
            while (true) {
                if (Get_PG_btnListPublis().getText().equals("Yayından Kaldır")) {
                    JobJob();
                    break;
                }
                sleep(1000);
            }
        } else {
            JobJob();
        }
    }

    private void JobJob() throws InterruptedException {
        String galleryTitle = Get_PG_listTitle().getText();
        Get_PG_listTitle().click();
        WebElement saveAndPublish = Get_PG_btnSaveDropdown();
        jsExecuter(saveAndPublish, "arguments[0].scrollIntoView(true);");
        sleep(1000);
        Get_PG_btnSaveDropdown().click();
        sleep(1000);
        Get_PG_btnUnpublish().click();
        Get_PG_btnUnPublishOK().click();
        while (true) {
            if (Get_PG_btn_OK_unpublish_Popup().size() == 0) {
                navigateTo("http://admin-staging.ntv.com.tr/PhotoGallery/List");
                if (Get_PG_listStatus().getText().equals("Yayında Değil")) {
                    logger.log(LogStatus.PASS, galleryTitle + " Adlı Galeri Yayından Kaldırıldı");
                } else {
                    logger.log(LogStatus.FAIL, galleryTitle + " Adlı Galeri Yayından Kaldırılamadı");
                    System.out.println("Galeri Yayından Kaldırılamadı!!!");
                }
                break;
            }
            sleep(2000);
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




