package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;

public class Cookie_Policy {
    //Cookie Policy Elements
    public static By ntvCookiePolicy = By.className("cookie-popup");

    public static WebElement Get_ntvCookiePolicy() {
        return getElement(ntvCookiePolicy);
    }

    public static By ntvCookiePolicyDetail = By.className("cookie-popup-detail-link");

    public static WebElement Get_ntvCookiePolicyDetail() {
        return getElement(ntvCookiePolicyDetail);
    }

    public static By ntvBtnCookiePolicyRead = By.cssSelector(".cookie-popup-btn.js-cookie-popup-close");

    public static WebElement Get_ntvBtnCookiePolicyRead() {
        return getElement(ntvBtnCookiePolicyRead);
    }
//Cookie Policy Elements
}
