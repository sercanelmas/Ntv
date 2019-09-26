package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utils.Definitions.getElement;
import static Utils.Definitions.getElements;

public class PG_Btn {
    public static By btn_photoGalleries = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/aside[1]/section[1]/section[1]/div[1]/div[1]/nav[1]/ul[1]/li[12]/a[1]/span[2]");
    public static By btn_photoGalleryList = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/header[1]/a[1]/i[1]");
    public static By btn_PG_ImageSearch = By.id("btn_mainArtSearch_0");
    public static By btn_continue = By.id("btn_photoGallerySave");
    public static By btn_uploadImage = By.xpath("/html[1]/body[1]/photo-gallery[1]/aside[1]/section[1]/fieldset[1]/div[1]/div[1]/div[2]/input[1]");
    public static By btn_PGSave = By.id("btn_save");
    public static By btn_PGSaveDropdown = By.xpath("/html[1]/body[1]/photo-gallery[1]/aside[1]/div[3]/div[1]/button[2]/span[1]");
    public static By btn_PGSavePublish = By.id("btn_publish");
    public static By btn_PGBrowse = By.xpath("/html[1]/body[1]/photo-gallery[1]/div[3]/div[1]/div[1]/a[1]");
    public static By btn_PGSaveAndBackToList = By.id("btn_saveAndReturnToList");
    public static By btn_PGListPublish = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/div[3]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/button[1]");
    public static By btn_PGUnpublishOK = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/button[2]");

    public static By btn_saveAndDontUpdateTimelineTime = By.id("btn_saveAndDontUpdateTimelineTime");
    public static By btn_saveAndUpdateTimelineTime = By.id("btn_saveAndUpdateTimelineTime");
    public static By btn_PGUnpublish = By.xpath("/html[1]/body[1]/photo-gallery[1]/aside[1]/div[3]/div[1]/ul[1]/li[6]");

    public static List<WebElement> Get_PG_btn_OK_unpublish_Popup() {
        return getElements(btn_PGUnpublishOK);
    }


    public static WebElement Get_btnPhotoGalleries() {
        return getElement(btn_photoGalleries);
    }

    public static WebElement Get_btnPhotoGalleryList() {
        return getElement(btn_photoGalleryList);
    }

    public static WebElement Get_btnPG_ImageSearch() {
        return getElement(btn_PG_ImageSearch);
    }

    public static WebElement Get_PG_btn_photoGallerySave() {
        return getElement(btn_continue);
    }

    public static WebElement Get_PG_btn_uploadImage() {
        return getElement(btn_uploadImage);
    }

    public static WebElement Get_PG_btnPGSave() {
        return getElement(btn_PGSave);
    }

    public static WebElement Get_PG_btnSaveDropdown() {
        return getElement(btn_PGSaveDropdown);
    }

    public static WebElement Get_PG_btnSavePublish() {
        return getElement(btn_PGSavePublish);
    }

    public static WebElement Get_PG_btnBrowse() {
        return getElement(btn_PGBrowse);
    }

/*
    public static WebElement Get_a_Browse() {
        return getElement(a_Browse);
    }
*/

    public static WebElement Get_PG_btnSaveAndBackToList() {
        return getElement(btn_PGSaveAndBackToList);
    }

    public static WebElement Get_PG_btnListPublis() {
        return getElement(btn_PGListPublish);
    }

    public static WebElement Get_PG_btnUnPublishOK() {
        return getElement(btn_PGUnpublishOK);
    }

    public static WebElement Get_PG_btnsaveAndDontUpdateTimelineTime() {
        return getElement(btn_saveAndDontUpdateTimelineTime);
    }

    public static WebElement Get_PG_btnSaveAndUpdateTimelineTime() {
        return getElement(btn_saveAndUpdateTimelineTime);
    }

    public static WebElement Get_PG_btnUnpublish() {
        return getElement(btn_PGUnpublish);
    }
}
