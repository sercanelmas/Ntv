package Stories;

import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import Utils.Admin_Driver;

import java.util.concurrent.TimeUnit;

import static Utils.Definitions.*;
import static java.lang.Thread.*;
import static Elements.Story_Btn.*;
import static Elements.Story_Elements.*;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

public class Story_Save_and_Publish extends Admin_Driver {
    ExtentTest logger;
    // Yayında Olan Haber İçin "Kaydet ve Yayına Al"

    @After
    public void Story_Save_and_Publish() throws InterruptedException {
        logger = Definitions.extent.startTest("Haber - Kaydet ve Yayınla");

        if (!driver.getCurrentUrl().equals("http://admin-staging.ntv.com.tr/Story/List")) {
            driver.navigate().to("http://admin-staging.ntv.com.tr/Story/List");
        }

        Get_newStory().click();

        Get_storyTitle().click();
        Get_storyTitle().sendKeys(mainTitle);

        Get_imageSearch().click();
        WaitAndClick(imageSelect);

        Get_spot().clear();
        WebElement spotArea = Get_spot();
        randomElementForTextGenerator(spotArea, 30);

        Get_newContent().clear();
        WebElement newContentArea = Get_newContent();
        randomElementForTextGenerator(newContentArea, 250);
        Get_newShortTitle().sendKeys(mainTitle);

        Scroll(-250);
        sleep(2000);

        Get_btnCategory().click();
        sleep(5000);

        Get_selectCategory().click();

        Scroll(400);
        sleep(1000);

        Get_storyTagArea().click();
        sleep(2000);
        Get_newTag0().click();

        Get_storyTagArea().click();
        sleep(2000);
        Get_newTag1().click();

        Get_storyTagArea().click();
        sleep(2000);
        Get_newTag2().click();

        Get_btn_SaveDropdown().click();
        Get_btn_saveAndPublish().click();

        String url = Get_btn_goToStory().getAttribute("href");
        Definitions.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        try {
            navigateTo(url);
            if (driver.getTitle().equals(mainTitle + " | NTV")) {
                logger.log(LogStatus.PASS, mainTitle + " Başlığı ile Haber Oluşturuldu");
            } else {
                logger.log(LogStatus.FAIL, "Haber Oluşturulamadı");
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
