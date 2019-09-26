package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;

public class Logos {
    //Logo Elements
    public static By ntvSporLogo = By.cssSelector(".ntv-spor-redirection.spor-first");

    public static WebElement Get_ntvSporLogo() {
        return getElement(ntvSporLogo);
    }

    public static By ntvParaOrj = By.cssSelector(".ntv-para-orj");

    public static WebElement Get_ntvParaOrj() {
        return getElement(ntvParaOrj);
    }

    public static By ntvParaOnly = By.cssSelector(".para-only");

    public static WebElement Get_ntvParaOnly() {
        return getElement(ntvParaOnly);
    }
//Logo Elements

    // Header //

    public static By header = By.id("sticky-wrapper");

    public static WebElement Get_header() {
        return getElement(header);
    }

    public static By headerClass = By.xpath("//nav[@class='main']");
    public static WebElement Get_headerClass(){return getElement(headerClass);}
}
