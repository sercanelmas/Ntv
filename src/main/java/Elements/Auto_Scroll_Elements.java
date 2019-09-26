package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;

public class Auto_Scroll_Elements {
    // Balik
    public static By astrolojiDiv = By.className("astrology");
    public static WebElement Get_astrolojiDiv (){return getElement(astrolojiDiv);}

    public static By kocBurcu = By.xpath("//a[@title='Koç Burcu']");
    public static WebElement Get_kocBurcu (){return getElement(kocBurcu);}

    public static By bogaBurcu = By.xpath("//a[@title='Boğa Burcu']");
    public static WebElement Get_bogaBurcu (){return getElement(bogaBurcu);}

    public static By ikizlerBurcu = By.xpath("//a[@title='İkizler Burcu']");
    public static WebElement Get_ikizlerBurcu (){return getElement(ikizlerBurcu);}

    public static By yengecBurcu = By.xpath("//a[@title='Yengeç Burcu']");
    public static WebElement Get_yengecBurcu (){return getElement(yengecBurcu);}

    public static By aslanBurcu = By.xpath("//a[@title='Aslan Burcu']");
    public static WebElement Get_aslanBurcu (){return getElement(aslanBurcu);}

    public static By basakBurcu = By.xpath("//strong[contains(text(),'Başak')]");
    public static WebElement Get_basakBurcu (){return getElement(basakBurcu);}

    public static By teraziBurcu = By.xpath("//a[@title='Terazi Burcu']");
    public static WebElement Get_teraziBurcu (){return getElement(teraziBurcu);}

    public static By akrepBurcu = By.xpath("//a[@title='Akrep Burcu']");
    public static WebElement Get_akrepBurcu (){return getElement(akrepBurcu);}

    public static By yayBurcu = By.xpath("//a[@title='Yay Burcu']");
    public static WebElement Get_yayBurcu (){return getElement(yayBurcu);}

    public static By oglakBurcu = By.xpath("//a[@title='Oğlak Burcu']");
    public static WebElement Get_oglakBurcu (){return getElement(oglakBurcu);}

    public static By kovaBurcu = By.xpath("//a[@title='Kova Burcu']");
    public static WebElement Get_kovaBurcu (){return getElement(kovaBurcu);}

    public static By balikBurcu = By.xpath("//a[@title='Balık Burcu']");
    public static WebElement Get_balikBurcu (){return getElement(balikBurcu);}
}
