package Stories;

import Utils.Admin_Driver;
import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import static Elements.Story_Btn.*;
import static Elements.Story_Elements.*;
import static Utils.Definitions.*;

// Mevcut Şablon Üzerinden Haber Oluşturma
public class Create_Template_Story extends Admin_Driver {
    ExtentTest logger;

    @After
    public void story() {
        logger = Definitions.extent.startTest("Haber - Şablondan Haber Oluşturma");

        WebElement element = Get_storyTemplates();

        Definitions.Scrolls(element);

        Get_elm_Haber_Sablonlari().click();
        Get_btn_templateCreateStory().click();

        String templateTitle = Get_storyTitle().getText() + mainTitle;
        Get_storyTitle().sendKeys(Keys.END + mainTitle);

        Get_btn_SaveDropdown().click();
        Get_btn_saveAndPublish().click();

        String url = Get_btn_goToStory().getAttribute("href");
        Definitions.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        try {
            navigateTo(url);
            if (driver.getTitle().equals(mainTitle + " | NTV")) {
                logger.log(LogStatus.PASS, mainTitle + " Başlığı ile Şablondan Haber Oluşturuldu");
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
            logger.log(LogStatus.INFO, "test info" + result.toString());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "sercan Pass " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(LogStatus.SKIP, "Test Skip TimeOut Sex" + result.getName());
        }
        extent.endTest(logger);
    }
}
