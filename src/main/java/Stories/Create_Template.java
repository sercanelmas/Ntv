package Stories;

import static Elements.Story_Elements.*;
import static Elements.Story_Btn.*;

import Utils.Definitions;

import static Utils.Definitions.*;
import static java.lang.Thread.*;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import Utils.Admin_Driver;


public class Create_Template extends Admin_Driver {
    ExtentTest logger;
    // Yeni Haber Şablonu Oluşturma

    @After
    public void Create_Template() throws InterruptedException {

        logger = Definitions.extent.startTest("Haber - Şablon Oluşturma");


        DateFormat dateFormat = new SimpleDateFormat("yyyymmddHHmmss");
        Date date = new Date();

        String date1 = dateFormat.format(date);
        String mainTitle = "Şablon " + date1;

        WebElement haberSablonlari = Get_elm_Haber_Sablonlari();
        jsExecuter(haberSablonlari, "arguments[0].scrollIntoView(true);");
        haberSablonlari.click();

        assertTrue(driver.getTitle().contains("Şablon Listesi"));
        System.out.println("Şablon Listesi Sayfasına Giriş Yapıldı");

        WaitAndClick(btn_storyTemplateCreate);

        assertTrue(driver.getCurrentUrl().contains("http://admin-staging.ntv.com.tr/Story/Create?template=True"));
        System.out.println("Şablon Oluştur Sayfası Yüklendi");

        Get_storyTitle().sendKeys(mainTitle);
        Get_imageSearch().click();

        WaitAndClick(imageSelect);
        //Definitions.wait.until(ExpectedConditions.elementToBeClickable(Definitions.imageSelect));
        //Definitions.Get_imageSelect().click();

        WebElement spotArea = Get_spot();
        randomElementForTextGenerator(spotArea, 30);

        WebElement contentArea = Get_newContent();
        randomElementForTextGenerator(contentArea, 250);


        Get_templateName().sendKeys(mainTitle);
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

        Get_btnTemplateSave().click();

        List<WebElement> liste = Get_PanelHeading();

        String tcn = liste.get(liste.size() - 1).getAttribute("innerText");
        if (mainTitle.equals(tcn)) {
            logger.log(LogStatus.PASS, mainTitle + " Başlığı ile Haber Şablonu Oluşturuldu");
            //System.out.println("Şablon Kaydedildi");
        } else {
            //System.out.println("Şablon Kaydedilemedi");
            logger.log(LogStatus.FAIL, " Haber Şablonu Başlığı Hatalı Oluştu veya Şablon Oluşturulamadı");
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