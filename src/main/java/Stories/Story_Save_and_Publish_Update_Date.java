package Stories;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import Utils.Admin_Driver;

import static Elements.Story_Btn.*;

import Utils.Admin_Driver;
import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;

import static Elements.Story_Elements.*;

import org.openqa.selenium.TimeoutException;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import static Utils.Definitions.*;

public class Story_Save_and_Publish_Update_Date extends Admin_Driver {
    ExtentTest logger;

    // Yayında Olan Haber için "Kaydet, Yayına Al ve Güncelleme Zamanını Yenile"
    @After
    public void Story_Save_and_Publish_Update_Date(){
        logger = Definitions.extent.startTest("Haber - Kaydet Yayınla ve Yayınlanma Tarihini Güncelle");

        Get_btn_Edit().click();

        Get_storyTitle().clear();
        Get_storyTitle().sendKeys(mainTitle);

        Get_newShortTitle().clear();
        Get_newShortTitle().sendKeys(mainTitle);

        Get_btn_SaveDropdown().click();
        Get_btn_saveAndPublish().click();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
        String date1 = format1.format(calendar.getTime());

        String url = Get_btn_goToStory().getAttribute("href");
        Definitions.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        try {
            navigateTo(url);
            if (driver.getTitle().equals(mainTitle + " | NTV")
                    && checkElement(lastUpdateCss)
                    && Get_lastUpdateCss().getText().equals("Son Güncelleme : " + date1)) {
                logger.log(LogStatus.PASS, mainTitle + " Haberi Kaydedildi, Yayınlandı ve Yayınlanma Tarihi Güncellendi");
            } else {
                logger.log(LogStatus.FAIL, mainTitle + " Haberi Kaydedilddi ve Yayınlandı, Ancak Yayınlanma Saatinde Sorun Var");
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
