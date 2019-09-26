package Stories;

import static Elements.Story_Btn.*;

import Utils.Definitions;
import Utils.Admin_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import Utils.Admin_Driver;

import static Utils.Definitions.*;
import static Elements.Story_Elements.*;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

public class Story_Delete extends Admin_Driver {

    ExtentTest logger;


    @After
    public void story_delete() throws InterruptedException {
        logger = Definitions.extent.startTest("Haber - Silme");

        Get_btn_Edit().click();
        Get_btn_Delete().click();
        Get_btn_OK_unpublish_Popup().click();

        while (true) {
            if (Get_btn_OK_unpublish_Popups().size() == 0) {
                logger.log(LogStatus.FAIL, "Haber Silinemedi");
                //System.out.println("Haber Silinemedi");
                CreateNews();
                break;
            } else {
                String title = Get_listTitle().getText();
                if (driver.getCurrentUrl().equals("http://admin-staging.ntv.com.tr/Story/List") &&
                        Get_listTitle().getText() != title) {
                    logger.log(LogStatus.PASS,"Haber Başarıyla Silindi");
                    //System.out.println("Haber Silindi");
                    break;
                }
            }
            Thread.sleep(2000);
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

