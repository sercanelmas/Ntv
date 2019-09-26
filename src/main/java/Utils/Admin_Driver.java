package Utils;

import Elements.PG_Elements;
import Stories.Story_Save_and_Publish;
import Utils.Definitions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static Utils.Definitions.*;


public class Admin_Driver {
    //ExtentReports extent;
    //ExtentTest logger;

    @Before
    public void setUp() {

        driverSettings();
    }

    @Test
    public void login() {
        navigateTo(stagingadmin);
        WaitAndClick(userName);
        Get_userName().sendKeys("sercan.elmas@dygdigital.com");
        Get_password().sendKeys("saSA''=(13");
        Get_loginButton().click();
    }

    @After
    public void endReport(){
        extent.flush();
        driver.quit();
    }


    public void CreateNews() throws InterruptedException {
        Story_Save_and_Publish story_save_and_publish = new Story_Save_and_Publish();
        story_save_and_publish.Story_Save_and_Publish();
    }

}