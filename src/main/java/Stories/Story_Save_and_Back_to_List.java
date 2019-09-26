package Stories;

import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.WebElement;
import Utils.Admin_Driver;

import static Elements.Story_Btn.*;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

import static Utils.Definitions.*;
import static java.lang.Thread.*;
import static Elements.Story_Elements.*;

public class Story_Save_and_Back_to_List extends Admin_Driver {

    ExtentTest logger;

    // Yeni Haber İçin Kaydet ve Listeye Dön İşlemi
    @After
    public void Story_Save_and_Back_to_List() throws InterruptedException {

        logger = Definitions.extent.startTest("Haber - Kaydet ve Listeye Dön");

        Get_newStory().click();

        ClickAndSend(storyTitle, mainTitle);

        Get_imageSearch().click();
        WaitAndClick(imageSelect);

        Get_spot().clear();
        WebElement spotArea = Get_spot();
        randomElementForTextGenerator(spotArea, 30);

        Get_newContent().clear();
        WebElement newContentArea = Get_newContent();
        randomElementForTextGenerator(newContentArea, 250);

        ClickAndSend(newShortTitle, mainTitle);

        Scroll(-250);
        sleep(2000);

        Get_btnCategory().click();
        sleep(5000);

        Get_selectCategory().click();

        Scroll(400);
        sleep(1000);


        WebElement tagArea = Get_storyTagArea();
        tagArea.click();
        sleep(2000);
        Get_newTag0().click();

        tagArea.click();
        sleep(2000);
        Get_newTag1().click();

        tagArea.click();
        sleep(2000);
        Get_newTag2().click();

        Get_btn_SaveDropdown().click();
        Get_btn_saveAndReturnList().click();

        sleep(1500);
        String story_Title = Get_listTitle().getText();
        if (Get_listTitle().getText().equals(mainTitle) &&
                Get_listStatus().getText().equals("Yeni") &&
                Get_btnListPublish().getText().equals("Yayınla")) {
            logger.log(LogStatus.PASS, story_Title + " Haberi Yayınlanmadan Kaydedildi ve Listeye Dönüldü");

        } else {
            logger.log(LogStatus.FAIL, " Haber Kaydedilemedi");
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
