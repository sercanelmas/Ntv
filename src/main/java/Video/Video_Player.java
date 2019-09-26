package Video;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;

import java.util.ArrayList;

import static Elements.Video.*;

import static Utils.Definitions.*;
import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;
import static java.lang.Thread.*;

public class Video_Player extends NTV_Driver {
    ExtentTest logger;
    int sayac = 0;

    @After
    public void Video_Player() throws InterruptedException {
        logger = extent.startTest("Video Player");

        Get_videoGallery().click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Get_firstVideo().click();
        if (checkElement(player) || checkElement(playing)) {
            while (true) {
                boolean boolAutoPlay = Get_player().getAttribute("data-player-autoplay").equals("true");
                boolean userInActivePlay = Get_playing().getAttribute("class").contains("vjs-playing vjs-has-started vjs-once-started vjs-user-active");
                boolean userInActivePlayII = Get_playing().getAttribute("class").contains("vjs-playing vjs-has-started vjs-once-started vjs-user-inactive");
                if ((boolAutoPlay) && (userInActivePlay || userInActivePlayII)) {
                    logger.log(PASS, "Video Player Otonatik Oynatılıyor");
                    playerProperti();
                    break;
                } else {
                    sayac++;
                    if (sayac == 20) {
                        logger.log(FAIL, "Video Player 20 Saniye Boyunca Otomatik Olarak Oynatılamadı");
                        break;
                    }
                }
                sleep(1000);
            }

        } else {
            logger.log(LogStatus.FAIL, "Player Yüklenemiyor");
        }
    }

    public void playerProperti() throws InterruptedException {
        //Durdur Başlat
        Get_btnPause().click();
        sleep(1000);
        if (Get_playing().getAttribute("class").contains("vjs-paused")) {
            logger.log(PASS, "Video Duraklatıldı");
            Get_btnPlay().click();
            sleep(1000);
            if (Get_playing().getAttribute("class").contains("vjs-has-started vjs-once-started vjs-user-active vjs-playing")) {
                logger.log(PASS, "Video Duraklatıldıktan Sonra Tekrar Başlatılabiliyor");
            } else {
                logger.log(FAIL, "Video Duraklatıldıktan Sonra Tekrar Başlatılamıyor");
            }
        } else {
            logger.log(FAIL, "Video Duraklatılamıyor");
        }
// Ses Kapa Aç
        Get_btnVolume().click();
        sleep(1000);
        if (Get_volumeDiv().getAttribute("class").contains("vjs-vol-0")) {
            logger.log(PASS, "Videonun Sesi Kısılıyor");
            Get_btnVolume().click();
            sleep(1000);
            if (!Get_volumeDiv().getAttribute("class").contains("vjs-vol-0")) {
                logger.log(PASS, "Videonun Sesi Kısıldıktan Sonra Tekrar Açılabiliyor.");
            } else {
                logger.log(FAIL, "Videonun Sesi Kısıldıktan Sonra Tekrar Açılamıyor");
            }
        } else {
            logger.log(FAIL, "Videonun Sesi Kısılamıyor");
        }

//Tam Ekrana Geç / Çık
        Get_btnFullScreen().click();
        sleep(1000);
        if (Get_playing().getAttribute("class").contains("fullscreen")) {
            logger.log(PASS, "Player Tam Ekran Modunda Oynatılabiliyor");
            Get_btnFullScreen().click();
            sleep(1000);
            if (Get_playing().getAttribute("class").contains("vjs-once-started vjs-playing vjs-user-active") ||
                    Get_playing().getAttribute("class").contains("vjs-once-started vjs-user-active vjs-playing")) {
                logger.log(PASS, "Player Tam Ekran Modundan Çıkarılabiliyor");
            } else {
                logger.log(FAIL, "Player Tam Ekran Modundan Çıkarılamıyor");
            }
        } else {
            logger.log(FAIL, "Player Tam Ekran Modunda Oynatılamıyor");
        }
    }
}
