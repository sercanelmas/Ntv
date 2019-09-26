package Photo_Galleries;

import static Elements.PG_Btn.*;
import static Elements.PG_Elements.*;

import Elements.PG_Elements;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import static Utils.Definitions.*;
import static java.lang.Thread.*;
import Utils.Admin_Driver;


public class Photo_Gallery_Save extends Admin_Driver {
    ExtentTest logger;

    @After
    public void photo_gallery_save() throws InterruptedException {

        logger = extent.startTest("Foto Galeri - Kaydet");

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

        Get_PG_btnPGSave().click();

        navigateTo("http://admin-staging.ntv.com.tr/PhotoGallery/List");
        String galleryTitle = Get_PG_listTitle().getText();
        if (Get_PG_listTitle().getText().equals(mainTitle) &&
                Get_PG_listStatus().getText().equals("Yeni")) {
            logger.log(LogStatus.PASS, galleryTitle + " Adıyla Yeni Bir Foto Galeri Oluşturuldu");
        } else {
            logger.log(LogStatus.FAIL, "Galeri Kaydedilemedi");
        }

    }

    @AfterTest
    public void getResult(ITestResult result) {

        writeLastLog(result, logger);
        extent.endTest(logger);
    }
}

