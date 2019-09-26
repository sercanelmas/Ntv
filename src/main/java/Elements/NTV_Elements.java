package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;

public class NTV_Elements {
    //Category Elements
    public static By catTurkiye = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/nav[1]/div[1]/ul[1]/li[3]/a[1]");

    public static WebElement Get_catTurkiye() {
        return getElement(catTurkiye);
    }

    public static By catTurkiyeContent = By.cssSelector(".pluto-lazy.small.short.loaded");

    public static WebElement Get_catTurkiyeContent() {
        return getElement(catTurkiyeContent);
    }

    public static By catEgitim = By.className(" egitim ");

    public static WebElement Get_catEgitim() {
        return getElement(catEgitim);
    }

    public static By catEgitimContent = By.cssSelector(".pluto-lazy.small.short.loaded");

    public static WebElement Get_catEgitimContent() {
        return getElement(catEgitimContent);
    }

    public static By catDunya = By.className(" dunya ");

    public static WebElement Get_catDunya() {
        return getElement(catDunya);
    }

    public static By catDunyaContent = By.cssSelector(".pluto-lazy.loaded");

    public static WebElement Get_catDunyaContent() {
        return getElement(catDunyaContent);
    }

    public static By catTeknoloji = By.className(" teknoloji ");

    public static WebElement Get_catTeknoloji() {
        return getElement(catTeknoloji);
    }

    public static By catTeknolojiContent = By.cssSelector(".pluto-lazy.loaded");

    public static WebElement Get_catTeknolojiContent() {
        return getElement(catTeknolojiContent);
    }

    public static By catYasam = By.className(" yasam ");

    public static WebElement Get_catYasam() {
        return getElement(catYasam);
    }

    public static By catYasamContent = By.cssSelector(".pluto-lazy.small.short.loaded");

    public static WebElement Get_catYasamContent() {
        return getElement(catYasamContent);
    }

    public static By catSaglik = By.className(" saglik ");

    public static WebElement Get_catSaglik() {
        return getElement(catSaglik);
    }

    public static By catSaglikContent = By.cssSelector(".pluto-lazy.loaded");

    public static WebElement Get_catSaglikContent() {
        return getElement(catSaglikContent);
    }

    public static By catSanat = By.className(" sanat ");

    public static WebElement Get_catSanat() {
        return getElement(catSanat);
    }

    public static By catSanatContent = By.cssSelector(".pluto-lazy.small.short.loaded");

    public static WebElement Get_catSanatContent() {
        return getElement(catSanatContent);
    }
//Category Elements
}


