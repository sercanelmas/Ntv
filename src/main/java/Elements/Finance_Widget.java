package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;

public class Finance_Widget {
    //Finance Widget Elements
    public static By ntvFinanceWidget = By.cssSelector(".finance-widget");

    public static WebElement Get_ntvFinanceWidget() {
        return getElement(ntvFinanceWidget);
    }

    public static By ntvFinanceBist = By.xpath("//div[@class='finance-widget']//ul//li[1]//a[1]");

    public static WebElement Get_ntvFinanceBist() {
        return getElement(ntvFinanceBist);
    }

    public static By ntvFinanceDollar = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]");

    public static WebElement Get_ntvFinanceDollar() {
        return getElement(ntvFinanceDollar);
    }

    public static By ntvFinanceEuro = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]");

    public static WebElement Get_ntvFinanceEuro() {
        return getElement(ntvFinanceEuro);
    }

    public static By ntvFinanceGold = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]");

    public static WebElement Get_ntvFinanceGold() {
        return getElement(ntvFinanceGold);
    }

    public static By testbok = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");

    public static WebElement Get_testbok() {
        return getElement(testbok);
    }
//Finance Widget Elements
}
