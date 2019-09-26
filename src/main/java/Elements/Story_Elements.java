package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Utils.Definitions.getElement;
import static Utils.Definitions.getElements;

public class Story_Elements {
    public static By templateName = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[1]/section[1]/header[1]/div[4]/div[1]/input[1]");
    public static By storyTitle = By.id("uiTinymce0");
    public static By imageSearch = By.xpath("//a[@title='Resim Ara']");
    public static By imageSelect = By.xpath("//html//div[@tabindex='-1']//li[1]/a[1]");
    public static By spot = By.id("uiTinymce1");
    public static By shortTitle = By.id("Story_Title");
    public static By selectCategory = By.xpath("//li[@class='active-result'][contains(text(),'Kadına Şiddet')]");
    public static By storyTagArea = By.id("Story_TagIds_chosen");
    public static By tag0 = By.xpath("//li[@class='active-result'][contains(text(),'ERZİNCAN referandum sonuçları')]");
    public static By tag1 = By.xpath("//li[@class='active-result'][contains(text(),'ERZURUM referandum sonuçları')]");
    public static By tag2 = By.xpath("//li[@class='active-result'][contains(text(),'ESKİŞEHİR referandum sonuçları')]");
    public static By newTag_0 = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[9]/div[1]/div[1]/ul[1]/li[3]");
    public static By newTag_1 = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[9]/div[1]/div[1]/ul[1]/li[4]");
    public static By newTag_2 = By.xpath("/html[1]/body[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[9]/div[1]/div[1]/ul[1]/li[5]");
    public static By content = By.id("uiTinymce2");
    public static By newShortTitle = By.id("uiTinymce2");
    public static By newContent = By.id("uiTinymce3");
    public static By newStory = By.xpath("//a[@href='/Story/Create']//span[contains(text(),'Yeni Haber')]");
    public static By category = By.xpath("//li[@class='active-result'][contains(text(),'Kadına Şiddet')]");
    public static By listTitle = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]");
    public static By listStatus = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/div[3]/table[1]/tbody[1]/tr[1]/td[7]");
    public static By updateDate = By.xpath("/html[1]/body[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/section[1]/div[3]/table[1]/tbody[1]/tr[1]/td[5]");
    public static By warning_Popup = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]");
    public static By unpublish_Popup = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]");
    public static By elm_Haber_Sablonlari = By.xpath("//span[@class='font-bold'][contains(text(),'Haber Şablonları')]");
    public static By panelHeading = By.cssSelector(".panel-heading");
    public static By storyTemplates = By.xpath("//span[@class='font-bold'][contains(text(),'Haber Şablonları')]");
    public static By lastUpdateCss = By.cssSelector("span.latest-update.desktop-only");


    public static WebElement Get_storyTitle() {
        return getElement(storyTitle);
    }

    public static WebElement Get_imageSearch() {
        return getElement(imageSearch);
    }

    public static WebElement Get_spot() {
        return getElement(spot);
    }

    public static WebElement Get_elm_Haber_Sablonlari() {
        return getElement(elm_Haber_Sablonlari);
    }

    public static WebElement Get_imageSelect() {
        return getElement(imageSelect);
    }

    public static WebElement Get_content() {
        return getElement(content);
    }

    public static WebElement Get_templateName() {
        return getElement(templateName);
    }

    public static WebElement Get_shortTitle() {
        return getElement(shortTitle);
    }

    public static List<WebElement> Get_PanelHeading() {
        return getElements(panelHeading);
    }

    public static WebElement Get_selectCategory() {
        return getElement(selectCategory);
    }

    public static WebElement Get_Tag0() {
        return getElement(tag0);
    }

    public static WebElement Get_Tag1() {
        return getElement(tag1);
    }

    public static WebElement Get_Tag2() {
        return getElement(tag2);
    }

    public static WebElement Get_storyTagArea() {
        return getElement(storyTagArea);
    }

    public static WebElement Get_newContent() {
        return getElement(newContent);
    }

    public static WebElement Get_newTag0() {
        return getElement(newTag_0);
    }

    public static WebElement Get_newTag1() {
        return getElement(newTag_1);
    }

    public static WebElement Get_newTag2() {
        return getElement(newTag_2);
    }

    public static WebElement Get_newShortTitle() {
        return getElement(newShortTitle);
    }

    public static WebElement Get_newStory() {
        return getElement(newStory);
    }

    public static WebElement Get_updateDate() {
        return getElement(updateDate);
    }

    public static WebElement Get_listTitle() {
        return getElement(listTitle);
    }

    public static WebElement Get_listStatus() {
        return getElement(listStatus);
    }

    public static WebElement Get_storyTemplates() {
        return getElement(storyTemplates);
    }

    public static WebElement Get_lastUpdateCss () {return getElement(lastUpdateCss);}


}
