package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utils.Definitions.getElement;
import static Utils.Definitions.getElements;

public class Story_Btn {
    public static By btn_Category = By.id("Story_MainCategory_chosen");
    public static By btn_goToStory = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/a[1]");
    public static By btn_Save = By.id("btn_Save");
    public static By btn_saveAndPublish = By.id("btn_SaveAndPublish");
    public static By btn_SaveAndReturnList = By.id("btn_SaveAndReturnList");
    public static By btn_Edit = By.id("btn_edit_1");
    public static By btn_SavePublishAndNotTimelineUpdate = By.id("btn_SavePublishAndNotTimelineUpdate");
    public static By btn_Unpublish = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[1]/section[1]/header[1]/div[4]/div[1]/ul[1]/li[6]/a[1]");
    public static By btn_OK_unpublish_Popup = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[2]/button[2]");
    public static By btn_Delete = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[1]/section[1]/header[1]/div[4]/button[1]");
    public static By btn_templateSave = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[1]/section[1]/header[1]/div[4]/div[1]/button[1]");
    public static By btn_templateCreateStory = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/div[1]/div[1]/div[3]/a[3]");
    public static By btn_storyTemplateCreate = By.id("btn_storyTemplateCreate");
    public static By btn_listPublish = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/div[3]/table[1]/tbody[1]/tr[1]/td[9]/div[1]/button[1]");
    public static By btn_Admin_Panel = By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/a[1]");
    public static By btn_Cancel = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[2]/button[1]");
    public static By btn_HaberOlustur = By.id("btnCreateStoryFromTemplate");
    public static By btn_saveDropdown = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[1]/section[1]/header[1]/div[4]/div[1]/button[2]");


    public static WebElement Get_btn_Edit() {
        //bıdıt
        return getElement(btn_Edit);
    }
    public static WebElement Get_btn_SaveDropdown() {
        return getElement(btn_saveDropdown);
    }

    public static WebElement Get_btn_storyTemplateCreate() {
        return getElement(btn_storyTemplateCreate);
    }

    public static WebElement Get_btnCategory() {
        return getElement(btn_Category);
    }

    public static WebElement Get_btnSave() {
        return getElement(btn_Save);
    }


    public static WebElement Get_btn_saveAndPublish() {
        return getElement(btn_saveAndPublish);
    }

    public static WebElement Get_btn_goToStory() {
        return getElement(btn_goToStory);
    }

    public static WebElement Get_btnTemplateSave() {
        return getElement(btn_templateSave);
    }

    public static WebElement Get_btn_saveAndReturnList() {
        return getElement(btn_SaveAndReturnList);
    }

    public static WebElement Get_btn_SavePublishAndNotTimelineUpdate() {
        return getElement(btn_SavePublishAndNotTimelineUpdate);
    }

    public static WebElement Get_btn_Unpublish() {
        return getElement(btn_Unpublish);
    }

    public static WebElement Get_btn_OK_unpublish_Popup() {
        return getElement(btn_OK_unpublish_Popup);
    }

    public static WebElement Get_btn_Delete() {
        return getElement(btn_Delete);
    }

    public static List<WebElement> Get_btn_OK_unpublish_Popups() {
        return getElements(btn_OK_unpublish_Popup);
    }

    public static WebElement Get_btn_HaberOlustur() {
        return getElement(btn_HaberOlustur);
    }

    public static WebElement Get_btn_templateCreateStory() {
        return getElement(btn_templateCreateStory);
    }

    public static WebElement Get_btnListPublish() {
        return getElement(btn_listPublish);
    }
}
