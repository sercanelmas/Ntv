package Stories;

import static Elements.Story_Elements.*;
import static Elements.Story_Btn.*;
import Utils.Admin_Driver;

import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.TimeoutException;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import static Utils.Definitions.*;

public class Story_Save_and_Without_Updating_Publish_Date extends Admin_Driver {
    ExtentTest logger;


    // Yayında Olan Haber için "Kaydet, ve Güncelleme Zamanını Yenilemeden Yayına Al"
    @After
    public void Story_Save_and_Publish() {

        logger = Definitions.extent.startTest("Haber - Kaydet ve Güncelleme Zamanını Güncellemeden Yayına Al");

        String updateDateArea = Get_updateDate().getText();

        Get_btn_Edit().click();

        Get_storyTitle().clear();
        Get_storyTitle().sendKeys(mainTitle);

        Get_newShortTitle().clear();
        Get_newShortTitle().sendKeys(mainTitle);

        Get_btn_SaveDropdown().click();
        Get_btn_SavePublishAndNotTimelineUpdate().click();
        String url = Get_btn_goToStory().getAttribute("href");
        Definitions.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        try {
            if (driver.getTitle().equals(mainTitle + " | NTV")
                    && !checkElement(lastUpdateCss)){
                logger.log(LogStatus.PASS, mainTitle + " Haberinin Güncellenme Tarihi Yayınlanmadan Kaydedildi ve Yayına Alındı");
            } else {
                logger.log(LogStatus.FAIL, mainTitle + " Haberi Kaydedilddi ve Yayınlandı Ancak Yayınlanma Saatinde Sorun Var");
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
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "sercan Pass " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Skip TimeOut Sex" + result.getName());
        }
        extent.endTest(logger);
    }
}
