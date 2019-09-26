package Video;

import Utils.Admin_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;

import java.io.IOException;

import static Utils.Definitions.*;

public class newTest extends Admin_Driver {

    ExtentTest logger;

    @After
    public void test() throws IOException {
        logger = extent.startTest("Parti Başladı");
        String title = driver.getTitle();

        if (title.equals("asfasdf")) {
            logger.log(LogStatus.PASS, "Test Passed");
        } else {
            logger.log(LogStatus.FAIL, "Snapshot below: " + logger.addScreenCapture(capture()));
        }
    }

   /* @AfterMethod
    public void getResult(ITestResult result) throws IOException
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            String screenShotPath = Definitions.capture(driver, "screenShotName");
            logger.log(LogStatus.FAIL, result.getThrowable());
            logger.log(LogStatus.FAIL, "Snapshot below: " + logger.addScreenCapture(screenShotPath));
        }
        extent.endTest(logger);
    }*/
}
