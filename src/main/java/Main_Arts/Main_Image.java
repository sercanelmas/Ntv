package Main_Arts;

import Utils.Admin_Driver;
import com.relevantcodes.extentreports.*;
import org.junit.After;

import java.io.IOException;

import static Elements.Main_Arts.*;
import static Utils.Definitions.*;
import static com.relevantcodes.extentreports.LogStatus.*;
import static java.lang.Thread.sleep;

public class Main_Image extends Admin_Driver {
    ExtentTest logger;
    int time;

    @After
    public void main_image() throws InterruptedException, IOException {
        logger = extent.startTest("Ana Resimler");
        Get_mainArts().click();
        Get_btn_AddMainArts().click();
        Get_btn_uploadImage().sendKeys(uploadMainArtFolder);
        String img1_url = Get_img1().getAttribute("src");
        String img2_url = Get_img2().getAttribute("src");
        String img3_url = Get_img3().getAttribute("src");

        boolean codeImage1 = checkURL(img1_url);
        boolean codeImage2 = checkURL(img2_url);
        boolean codeImage3 = checkURL(img3_url);

        if (codeImage1 && codeImage2 && codeImage3) {
            Get_btn_save().click();
            while (true) {
                if (driver.getCurrentUrl().contains("ntv.com.tr/MainArt/List")) {
                    String listImg1_url = Get_listImg1().getAttribute("src");
                    String listImg2_url = Get_listImg2().getAttribute("src");
                    String listImg3_url = Get_listImg3().getAttribute("src");
                    boolean codeListImage1 = checkURL(listImg1_url);
                    boolean codeListImage2 = checkURL(listImg2_url);
                    boolean codeListImage3 = checkURL(listImg3_url);

                    if (codeListImage1 && codeListImage2 && codeListImage3) {
                        logger.log(PASS, "Main Art Başarıyla Kaydedildi");
                    } else {
                        logger.log(FAIL, "Main Art Doğru Şekilde Yüklenemedi: " + logger.addScreenCapture(capture()));
                    }
                    break;
                } else {
                    time++;
                    if (time == 20) {
                        logger.log(ERROR, "image'lar 20 sn boyunca kaydedilemedi: " + logger.addScreenCapture(capture()));
                        break;
                    }
                }
                sleep(1000);
            }

        } else {
            logger.log(FAIL, "Image'lar Yüklenemedi: " + logger.addScreenCapture(capture()));
        }
    }
}

