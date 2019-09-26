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
import static java.lang.Thread.sleep;

public class Next_Video extends NTV_Driver {
    ExtentTest logger;
    int sayac;

    @After
    public void Next_Video() throws InterruptedException {
        logger = extent.startTest("Sıradaki Videoya Geçiş");
        Get_videoGallery().click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Get_firstVideo().click();
        if (checkElement(player) && checkElement(playing)) {
            while (true) {
                boolean boolAutoPlay = Get_player().getAttribute("data-player-autoplay").equals("true");
                boolean userInActivePlay = Get_playing().getAttribute("class").contains("vjs-playing vjs-has-started vjs-once-started vjs-user-active");
                boolean userInActivePlayII = Get_playing().getAttribute("class").contains("vjs-playing vjs-has-started vjs-once-started vjs-user-inactive");
                if ((boolAutoPlay) && (userInActivePlay || userInActivePlayII)) {
                    next_video_control();
                    break;
                } else {
                    sayac++;
                    if (sayac == 20) {
                        logger.log(FAIL, "Açılan İlk Video Oynatılamıyor");
                        break;
                    }
                }
                sleep(1000);
            }

        } else {
            logger.log(LogStatus.FAIL, "Player Yüklenemiyor");
        }
        extent.endTest(logger);
    }

    public void next_video_control() throws InterruptedException {
        String videoTitle = driver.getTitle();
        while (true) {
            if (Get_playing().getAttribute("class").contains("ended")) {
                if (checkElement(nextVideoTimer)) {
                    //  sleep(500);
                    // if (Get_nextVideoTimer().getAttribute("stroke-dasharray").equals("0,20000")) {
                    while (true) {
                        System.out.println(Get_nextVideoTimer().getAttribute("stroke-dasharray"));
                        if (Get_nextVideoTimer().getAttribute("stroke-dasharray").equals("348,20000")) {
                            break;
                        } else {
                            sayac++;
                            if (sayac == 7) {
                                logger.log(FAIL, "Sonraki Video İçin Geri Sayım Süresi Dolmasına Rağmen Animasyon Gösterilmeye Devam Ediyor");
                                break;
                            }
                        }
                    }                    if (driver.getTitle() != videoTitle) {
                        logger.log(PASS, "Sonraki Videoya Otomatik Geçiş Yapılabiliyor");
                        break;
                    } else {
                        logger.log(FAIL, "Sonraki Videoya Geçiş Yapılamadı");
                        break;
                    }
                    // } else {
                    //logger.log(FAIL, "Sonraki Videoya Geçiş İçin Geri Sayım Yapılmıyor");
                }
                break;
            } else {
                sayac++;
                if (sayac == 7) {
                    logger.log(FAIL, "Sıradaki Videoya Geçiş Animasyonu Gösterilmiyor");
                }
            }
            sleep(1000);
        }
    }



  /*  public void countDown() {

    }*/
}

