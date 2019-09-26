package Elements;

import Utils.Definitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static Utils.Definitions.getElement;

public class PG_Elements {
    public static void photoUpload() throws InterruptedException {
        File[] files = getfiles();
        int uploadedPhotoListIndex = 1;
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getPath());
            PG_Btn.Get_PG_btn_uploadImage().sendKeys(files[i].getPath());

            Definitions.Wait(By.xpath("/html[1]/body[1]/photo-gallery[1]/main[1]/ul[1]/li[" + uploadedPhotoListIndex + "]/img[1]"));
            uploadedPhotoListIndex++;
            while (true) {
                if (Definitions.checkElement(PG_TryAgain)) {
                    Thread.sleep(1050);
                    Definitions.WaitAndClick(PG_btn_TryAgain);

                    PG_Btn.Get_PG_btn_uploadImage().sendKeys(files[i].getPath());
                    uploadedPhotoListIndex++;
                    Definitions.Wait(By.xpath("/html[1]/body[1]/photo-gallery[1]/main[1]/ul[1]/li[" + uploadedPhotoListIndex + "]/img[1]"));
                } else {
                    break;
                }
            }

        }
    }

    //util functions
    public static File[] getfiles() {
        File folder = new File(uploadImageFolder);
        return folder.listFiles();
    }

    public static String uploadImageFolder;//="C:\\Users\\sercan.elmas\\Pictures\\düdüt\\";

    public static List<WebElement> Get_uploadFailed() {
        return Definitions.getElements(uploadFailed);
    }

    public static By PG_ImageSearch = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]");
    public static By PG_Title = By.xpath("/html[1]/body[1]/photo-gallery[1]/aside[1]/section[1]/div[1]/h1[1]");
    public static By PG_ShortTitle = By.id("txtTitle");
    public static By PG_Spot = By.id("txtSpot");
    public static By PG_Category = By.id("btn_photoGalleryCategory");
    public static By PG_CategorySelect = By.xpath("//option[@value='6']");
    public static By uploadedImage0 = By.xpath("/html[1]/body[1]/photo-gallery[1]/main[1]/ul[1]/li[1]/img[1]");
    public static By uploadedImage1 = By.xpath("/html[1]/body[1]/photo-gallery[1]/main[1]/ul[1]/li[2]/img[1]");
    public static By uploadedImage2 = By.xpath("/html[1]/body[1]/photo-gallery[1]/main[1]/ul[1]/li[3]/img[1]");
    public static By uploadedImage3 = By.xpath("/html[1]/body[1]/photo-gallery[1]/main[1]/ul[1]/li[4]/img[1]");
    public static By uploadFailed = By.xpath("/html[1]/body[1]/photo-gallery[1]/aside[1]/section[1]/fieldset[1]/div[1]/div[1]/span[1]");
    public static By PG_TryAgain = By.cssSelector("qq-file-id-0 qq-upload-fail qq-upload-retryable");
    public static By PG_btn_TryAgain = By.cssSelector("qq-upload-retry-selector qq-upload-retry");
    public static By PG_listTitle = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");
    public static By PG_listStatus = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/div[3]/table[1]/tbody[1]/tr[1]/td[7]");
    public static By PG_lastUpdate = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[4]/div[1]/div[1]/article[1]/header[1]/time[1]/span[2]");
    public static By PG_lastUpdateCss = By.cssSelector("span.latest-update.desktop-only");
    public static By PG_tostMessageUnpublish = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]");

    public static WebElement Get_PG_ImageSearch() {
        return getElement(PG_ImageSearch);
    }

    public static WebElement Get_PG_Title() {
        return getElement(PG_Title);
    }

    public static WebElement Get_PG_ShortTitle() {
        return getElement(PG_ShortTitle);
    }

    public static WebElement Get_PG_Spot() {
        return getElement(PG_Spot);
    }

    public static WebElement Get_PG_Category() {
        return getElement(PG_Category);
    }

    public static WebElement Get_PG_CategprySelect() {
        return getElement(PG_CategorySelect);
    }

    public static WebElement Get_PG_listTitle() {
        return getElement(PG_listTitle);
    }

    public static WebElement Get_PG_listStatus() {
        return getElement(PG_listStatus);
    }

    public static WebElement Get_PG_lastUpdate() {
        return getElement(PG_lastUpdate);
    }

    public static WebElement Get_PG_lastUpdateCss() {
        return getElement(PG_lastUpdateCss);
    }


    public static WebElement Get_PG_tostMessage() {
        return getElement(PG_tostMessageUnpublish);
    }


}
