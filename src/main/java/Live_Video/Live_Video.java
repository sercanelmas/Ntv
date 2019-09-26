package Live_Video;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import org.junit.After;

import java.io.IOException;
import java.util.ArrayList;

import static Elements.Live_Video.*;
import static Utils.Definitions.*;
import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;

public class Live_Video extends NTV_Driver {
    ExtentTest logger;
    static int sayac = 0;

    @After
    public void Live_Video() throws InterruptedException, IOException {

        logger = extent.startTest("Canlı Yayın Testi");
        Get_btnLive().click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));

        if (checkElement(livePlayer)) {
            logger.log(PASS, "Canlı Yayın Player'ı Yükleniyor");

            while (true) {
                boolean boolAutoPlay = Get_livePlayer().getAttribute("data-player-autoplay").equals("true");
                boolean userInActivePlay = Get_playtest().getAttribute("class").contains("vjs-playing vjs-has-started vjs-user-inactive vjs-live vjs-once-started");
                boolean userInActivePlayII = Get_playtest().getAttribute("class").contains("vjs-playing vjs-has-started vjs-live vjs-once-started vjs-user-inactive");
                if ((boolAutoPlay) && (userInActivePlay || userInActivePlayII)) {
                    logger.log(PASS, "Video Player Otonatik Oynatılıyor");
                    playerProperties();
                    break;
                } else {
                    sayac++;
                    if (sayac == 20) {
                        logger.log(FAIL, "Video Player 20 Saniye Boyunca Otomatik Olarak Oynatılamadı: " + logger.addScreenCapture(capture()));
                        break;
                    }
                }
                Thread.sleep(1000);
            }
        } else {
            {
                logger.log(FAIL, "Canlı Yayın Player'ı Yüklenemiyor: " + logger.addScreenCapture(capture()));
            }
        }
    }

    private void playerProperties() throws InterruptedException, IOException {
        //Durdur Başlat
        Get_btnPause().click();
        Thread.sleep(1000);
        if (Get_playtest().getAttribute("class").contains("vjs-paused")) {
            logger.log(PASS, "Video Duraklatıldı");
            Get_btnPlay().click();
            Thread.sleep(1000);
            if (Get_playtest().getAttribute("class").contains("vjs-has-started vjs-live vjs-once-started vjs-user-active vjs-playing")) {
                logger.log(PASS, "Video Duraklatıldıktan Sonra Tekrar Başlatılabiliyor");
            } else {
                logger.log(FAIL, "Video Duraklatıldıktan Sonra Tekrar Başlatılamıyor: " + logger.addScreenCapture(capture()));
            }
        } else {
            logger.log(FAIL, "Video Duraklatılamıyor: " + logger.addScreenCapture(capture()));
        }
// Ses Kapa Aç
        Get_btnVolume().click();
        Thread.sleep(1000);
        if (Get_volumeDiv().getAttribute("class").contains("vjs-vol-0")) {
            logger.log(PASS, "Videonun Sesi Kısılıyor");
            Get_btnVolume().click();
            Thread.sleep(1000);
            if (Get_volumeDiv().getAttribute("class").contains("vjs-vol-1")) {
                logger.log(PASS, "Videonun Sesi Kısıldıktan Sonra Tekrar Açılabiliyor");
            } else {
                logger.log(FAIL, "Videonun Sesi Kısıldıktan Sonra Tekrar Açılamıyor: " + logger.addScreenCapture(capture()));
            }
        } else {
            logger.log(FAIL, "Videonun Sesi Kısılamıyor: " + logger.addScreenCapture(capture()));
        }

//Tam Ekrana Geç / Çık
        Get_btnFullScreen().click();
        Thread.sleep(1000);
        if (Get_playtest().getAttribute("class").contains("fullscreen")) {
            logger.log(PASS, "Player Tam Ekran Modunda Oynatılabiliyor");
            Get_btnFullScreen().click();
            Thread.sleep(1000);
            if (Get_playtest().getAttribute("class").contains("vjs-once-started vjs-playing vjs-user-active") ||
                    Get_playtest().getAttribute("class").contains("vjs-once-started vjs-user-active vjs-playing")) {
                logger.log(PASS, "Player Tam Ekran Modundan Çıkarılabiliyor");
            } else {
                logger.log(FAIL, "Player Tam Ekran Modundan Çıkarılamıyor: " + logger.addScreenCapture(capture()));
            }
        } else {
            logger.log(FAIL, "Player Tam Ekran Modunda Oynatılamıyor: " + logger.addScreenCapture(capture()));
        }
    }
}
