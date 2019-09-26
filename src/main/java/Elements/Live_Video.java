package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;

public class Live_Video {

    //Live Video Elements
    public static By btnLive = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]");

    public static WebElement Get_btnLive() {
        return getElement(btnLive);
    }

    public static By livePlayer = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[3]/div[1]/div[1]");

    public static WebElement Get_livePlayer() {
        return getElement(livePlayer);
    }

    public static By playtest = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]");

    public static WebElement Get_playtest() {
        return getElement(playtest);
    }

    public static By btnPause = By.cssSelector(".vjs-play-control.vjs-control.vjs-button.vjs-playing");

    public static WebElement Get_btnPause() {
        return getElement(btnPause);
    }

    public static By btnPlay = By.cssSelector(".vjs-play-control.vjs-control.vjs-button.vjs-paused");

    public static WebElement Get_btnPlay() {
        return getElement(btnPlay);
    }

    public static By volumeDiv = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]");

    public static WebElement Get_volumeDiv() {
        return getElement(volumeDiv);
    }

    public static By btnVolume = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]");

    public static WebElement Get_btnVolume() {
        return getElement(btnVolume);
    }

    //public static By btnVolumeUp = By.cssSelector(".vjs-volume-menu-button.vjs-menu-button.vjs-menu-button-inline.vjs-control.vjs-button.vjs-volume-menu-button-horizontal.vjs-vol-0");
    //public static WebElement Get_btnVolumeUp () {return getElement(btnVolumeUp);}

    public static By btnFullScreen = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[5]/button[2]");

    public static WebElement Get_btnFullScreen() {
        return getElement(btnFullScreen);
    }

//Live Video Elements
}
