package Photo_Galleries;

import Elements.PG_Elements;
import Utils.Admin_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static Elements.PG_Btn.*;
import static Elements.PG_Elements.*;
import static Utils.Definitions.*;
import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;
import static java.lang.Thread.sleep;

public class PG_Save_and_Back_to_List_on_Publish extends Admin_Driver {

    ExtentTest logger;

    @After // Var olan bir galeride değişiklik yaparak kaydeder ve listeye döner
    public void photo_gallery_save() throws InterruptedException, IOException {
        logger = extent.startTest("Foto Galeri - Canlıdaki Galeriyi Güncelle Kaydet ve Listeye Dön");
        Get_btnPhotoGalleries().click();


        if (PG_Elements.Get_PG_listStatus().getText().equals("Yayında Değil")) {
            Get_PG_btnListPublis().click();
            while (true) {
                if (Get_PG_btnListPublis().getText().equals("Yayından Kaldır")) {
                    Job();
                    break;
                }
                sleep(1000);
            }
        } else {
            Job();
        }
    }

    private void Job() throws InterruptedException, IOException {
        String galleryTitle = Get_PG_listTitle().getText();
        Get_PG_listTitle().click();
        Get_PG_Title().clear();
        Get_PG_Title().sendKeys(mainTitle);

        WebElement saveAndPublish = Get_PG_btnSaveDropdown();
        jsExecuter(saveAndPublish, "arguments[0].scrollIntoView(true);");
        sleep(1000);
        Get_PG_btnSaveDropdown().click();
        sleep(1000);
        Get_PG_btnSaveAndBackToList().click();
        sleep(1000);

        Wait(PG_Elements.PG_listTitle);

        if (Get_PG_listTitle().getText().equals(mainTitle) &&
                Get_PG_listStatus().getText().equals("Yayında Değil")) {
            logger.log(PASS, galleryTitle + " Adlı Galeri Kaydedildi ve Yayından Kaldırıldı");
        } else {
            logger.log(FAIL, galleryTitle + " Adlı Galeri Yayından Kaldırılamadı: " + logger.addScreenCapture(capture()));
        }
    }

 /*   @AfterTest
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(FAIL, "sercan fail-0 Failed is " + result.getName());
            logger.log(FAIL, "sercan fail-1 Failed is " + result.getThrowable());
            logger.log(INFO, "test info" + result.toString());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(PASS, "sercan Pass " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(SKIP, "Test Skip TimeOut Sex" + result.getName());
        }
        extent.endTest(logger);
    }*/
}
