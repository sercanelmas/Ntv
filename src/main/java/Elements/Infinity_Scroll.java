package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;

public class Infinity_Scroll {
    //infinity_Scroll
    public static By animation = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]");

    public static WebElement Get_animation() {
        return getElement(animation);
    }

    public static By animationPG = By.xpath("//span[@class='more']");
    public static WebElement Get_animationPG () {return getElement(animationPG);}

}
