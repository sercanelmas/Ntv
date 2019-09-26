package Stories;

import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import Utils.Admin_Driver;

import static Utils.Definitions.*;
import static java.lang.Thread.*;
import static Elements.Story_Elements.*;
import static Elements.Story_Btn.*;

public class Story_Unpublish extends Admin_Driver {

    ExtentTest logger;

    @After
    public void story_unpublish() throws InterruptedException {
        logger = Definitions.extent.startTest("Haber - Yayından Kaldır");
        String storyTitle = Get_listTitle().getText();
        Get_btn_Edit().click();

        Get_btn_SaveDropdown().click();
        WaitAndClick(btn_Unpublish);
        //Get_btn_Unpublish().click();

        Get_btn_OK_unpublish_Popup().click();

        while (true) {
            if (Get_btn_OK_unpublish_Popups().size() == 0) {
                driver.navigate().to(stagingadmin);
                if (Get_listStatus().getText().equals("Yayında Değil")) {
                    logger.log(LogStatus.PASS, storyTitle + " Haberi Yayından Kaldırıldı");
                    break;
                } else {
                    logger.log(LogStatus.FAIL, storyTitle + " Haberi Yayından Kalıdırılamadı");
                    break;
                }
            }
            sleep(2000);
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