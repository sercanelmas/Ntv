package Stories;

import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.WebElement;
import Utils.Admin_Driver;

import static Elements.Story_Elements.*;
import static Elements.Story_Btn.*;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import static Utils.Definitions.*;
import static java.lang.Thread.*;

public class Story_Save extends Admin_Driver {

    ExtentTest logger;

    // Yeni Haber için "Kaydet" İşlemi
    @After
    public void Story_Save() throws InterruptedException {
        logger = Definitions.extent.startTest("Haber - Kaydetme");
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

        Get_btnSave().click();
        sleep(1500);

        driver.get(stagingadmin);
        String storyTitle = Get_listTitle().getText();

        if (Get_listTitle().getText().equals(mainTitle) &&
                Get_listStatus().getText().equals("Yeni") &&
                Get_btnListPublish().getText().equals("Yayınla")) {

            logger.log(LogStatus.PASS, storyTitle + "Haberi Kaydedildi");
        } else {
            logger.log(LogStatus.FAIL, "Haber Kaydedilemedi");
        }

    }

    @AfterTest
    public void getResult(ITestResult result) {
        writeLastLog(result, logger);
        extent.endTest(logger);
    }
}