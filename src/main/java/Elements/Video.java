package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utils.Definitions.getElement;


public class Video {

    public static By videoGallery = By.xpath("//a[contains(text(),'VİDEO GALERİ')]");
    public static WebElement Get_videoGallery () {return getElement(videoGallery);}

    public static By firstVideo = By.xpath("//div[@class='vg-video-container__player']//figure//a");
    public static WebElement Get_firstVideo () {return getElement(firstVideo);}

    public static By player = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]");
    public static WebElement Get_player () {return getElement(player);}

    public static By playing = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    public static WebElement Get_playing () {return getElement(playing);}

    public static By btnPause = By.cssSelector(".vjs-play-control.vjs-control.vjs-button.vjs-playing");

    public static WebElement Get_btnPause() {
        return getElement(btnPause);
    }

    public static By btnPlay = By.cssSelector(".vjs-play-control.vjs-control.vjs-button.vjs-paused");

    public static WebElement Get_btnPlay() {
        return getElement(btnPlay);
    }

    public static By volumeDiv = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]");

    public static WebElement Get_volumeDiv() {
        return getElement(volumeDiv);
    }

    public static By btnVolume = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]");

    public static WebElement Get_btnVolume() {
        return getElement(btnVolume);
    }

    public static By btnVolumeUp = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]");

    public static WebElement Get_btnVolumeUp() {
        return getElement(btnVolumeUp);
    }

    public static By btnFullScreen = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/button[2]");

    public static WebElement Get_btnFullScreen() {
        return getElement(btnFullScreen);
    }

    public static By timeBarPercent = By.cssSelector(".vjs-play-progress.vjs-slider-bar");
    public static WebElement Get_timeBarPercent () {return getElement(timeBarPercent);}

    public static By timeBarLoc = By.cssSelector(".vjs-mouse-display");
    public static WebElement Get_timeBarLoc () {return getElement(timeBarLoc);}

    public static By nextVideoTimer = By.id(".next-video-svg-circle");
    public static WebElement Get_nextVideoTimer () {return getElement(nextVideoTimer);}

    public static By timeBar = By.cssSelector(".vjs-progress-holder.vjs-slider.vjs-slider-horizontal");
    public static WebElement Get_timeBar () {return getElement(timeBar);}




}
