package Utils;

import Elements.PG_Elements;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Elements.Infinity_Scroll.*;
import static com.relevantcodes.extentreports.LogStatus.*;

public class Definitions {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static DateFormat dateFormat = new SimpleDateFormat("yyyymmddHHmmss");
    public static Date date = new Date();
    public static String date1 = dateFormat.format(date);
    public static String mainTitle = "Test " + date1;

    public static String ntv = "https://www.ntv.com.tr/";
    public static String stagingadmin = "http://admin-staging.ntv.com.tr/";


    public static String screenShotPath = System.getProperty("user.dir") + "/test-output/";



    //////// Driver Elements //////////////
    public static By userName = By.id("Email");
    public static By password = By.id("Password");
    public static By loginButton = By.xpath("//button[@type='submit']");

    public static ExtentReports extent;


    //public static ExtentTest logger;

    public static WebElement Get_userName() {
        return getElement(userName);
    }

    public static WebElement Get_password() {
        return getElement(password);
    }

    public static WebElement Get_loginButton() {
        return getElement(loginButton);
    }


    public static String GenerateRandomText(int length) {
        return RandomString.make(length);
    }

    public static void jsExecuter(Object element, String jsCode) {
        ((JavascriptExecutor) Definitions.driver).executeScript(jsCode, element);
    }

    public static void Scroll(int pixel) {
        jsExecuter("", "window.scrollBy(0," + pixel + ")");

    }

    public static void Scrolls(WebElement element) {
        jsExecuter(element, "arguments[0].scrollIntoView(true)");
    }

    public static boolean hasClass(WebElement element, String htmlClassName) {
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equals(htmlClassName)) {
                return true;
            }
        }
        return false;
    }

    public static void randomElementForTextGenerator(WebElement element, int length) {
        element.clear();
        while (element.getText().length() <= length) {
            String currentText = element.getText();
            element.sendKeys(currentText + GenerateRandomText(7) + " ");
        }
    }

    public static WebElement getElement(By elementLocator) {
        return driver.findElement(elementLocator);
    }

    public static List<WebElement> getElements(By elementLocator) {
        return driver.findElements(elementLocator);
    }

    public static boolean checkElement(By elementLocator) {
        return driver.findElements(elementLocator).size() != 0;
    }

    public static void WaitAndClick(By elementDefinition) {
        wait.until(ExpectedConditions.elementToBeClickable(elementDefinition));
        getElement(elementDefinition).click();
    }

    public static void Wait(By elementDefinition) {
        wait.until(ExpectedConditions.elementToBeClickable(elementDefinition));
    }

    public static void ClickAndSend(By elementDefiniton, String text) {
        WebElement element = getElement(elementDefiniton);
        element.click();
        element.sendKeys(text);
    }

    public static boolean checkURL(String URL) throws IOException {
        int responseCode = Get_StatusURL(URL);
        return (responseCode == 200);
    }

    public static int Get_StatusURL(String URL) throws IOException {
        java.net.URL _url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) _url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        return connection.getResponseCode();
    }

    public static void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public static void writeLastLog(ITestResult result, ExtentTest logger) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(FAIL, "sercan fail-0 Failed is " + result.getName());
            logger.log(FAIL, "sercan fail-1 Failed is " + result.getThrowable());
            logger.log(INFO, "test info" + result.toString());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(PASS, "sercan Pass " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(SKIP, "Test Skip TimeOut" + result.getName());
        }
    }

    public static void driverSettings() {
        System.setProperty("webdriver.chrome.driver", "C:\\ProjectFolder\\chromedriver_win32\\chromedriver.exe");
        // chrome capabilities
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addExtensions(new File("C:\\ProjectFolder\\AdBlock_v3.34.0.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PG_Elements.uploadImageFolder = "C:\\Users\\sercan.elmas\\Pictures\\düdüt\\";

        if (extent == null) {
            extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/" + date1 + "_Test_Result.html", true);
            //extent.addSystemInfo("Environment","Environment Name")
            extent
                    .addSystemInfo("Host Name", "www.ntv.com.tr")
                    .addSystemInfo("Environment", "Automation Testing")
                    .addSystemInfo("User Name", "Sercan Elmas");
            //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
            //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
            extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
        }
    }

    public static String capture(String screenShotName) throws IOException
    {
        return captureBase(screenShotName);
    }

    public static String capture() throws IOException
    {
       return captureBase(null);
    }

    private static String captureBase(String imgName ) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = screenShotPath + ((imgName== null)? dateFormat.format(new Date()): imgName) +".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        return dest;
    }


    public static void scrollDown(ExtentTest logger) throws InterruptedException, IOException {
        int second = 0;
        while (true) {
            String title = driver.getTitle();
            if (checkElement(animation)) {
                jsExecuter(Get_animation(), "arguments[0].scrollIntoView(true);");
                Scroll(500);
                if (!title.equals(driver.getTitle())) {
                    logger.log(PASS, "Infinity Scroll Başarılı");
                    break;
                } else {
                    second++;
                    if (second == 20) {
                        logger.log(FAIL, "Infinity Scroll Yapılamıyor:" + logger.addScreenCapture(capture()));
                        break;
                    }
                }
                Thread.sleep(1000);
            } else if (checkElement(animationPG)) {
                jsExecuter(Get_animationPG(), "arguments[0].scrollIntoView(true);");
                Scroll(500);
                if (!title.equals(driver.getTitle())) {
                    logger.log(PASS, "Infinity Scroll Başarılı");
                    break;
                } else {
                    second++;
                    if (second == 20) {
                        logger.log(FAIL, "Infinity Scroll Yapılamıyor: " + logger.addScreenCapture(capture()));
                        break;
                    }
                }
                Thread.sleep(1000);
            }
        }
    }

    public static void retryScroll(ExtentTest logger) throws InterruptedException, IOException {
        String firsTitle = driver.getTitle();
        scrollDown(logger);
        if (!firsTitle.equals(driver.getTitle())) {
            String secondTitle = driver.getTitle();
            scrollDown(logger);
            if (!secondTitle.equals(driver.getTitle())) {
                scrollDown(logger);
            }
        }
    }
}




