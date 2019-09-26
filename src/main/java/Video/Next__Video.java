package Video;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;

import java.io.IOException;
import java.util.ArrayList;

import static Elements.Video.*;
import static Utils.Definitions.*;
import static com.relevantcodes.extentreports.LogStatus.FAIL;
import static com.relevantcodes.extentreports.LogStatus.PASS;
import static com.relevantcodes.extentreports.LogStatus.WARNING;
import static java.lang.Thread.sleep;

public class Next__Video extends NTV_Driver {
    ExtentTest logger;
    int sayac = 0;

    @After
    public void Video_Player() throws InterruptedException, IOException {
        logger = extent.startTest("Video Player");

        Get_videoGallery().click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        Get_firstVideo().click();
        String videoTitle = driver.getTitle();
        if (checkElement(player) || checkElement(playing)) {
            while (true) {
                boolean boolAutoPlay = Get_player().getAttribute("data-player-autoplay").equals("true");
                boolean userInActivePlay = Get_playing().getAttribute("class").contains("vjs-playing vjs-has-started vjs-once-started");
                if ((boolAutoPlay) && (userInActivePlay)) {
                    while (true) {
                        if (Get_playing().getAttribute("class").contains("ended") &&
                                Get_timeBar().getAttribute("aria-valuenow").equals("100.00")) {
                            sleep(7000);
                            if (!videoTitle.equals(driver.getTitle())) {
                                logger.log(PASS, "Sonraki Videoya Başarıyla Yönlendiriliyor" + logger.addScreenCapture(capture()));
                                break;
                            } else {
                                logger.log(FAIL, "Sıradaki Videoya Yönlendirme Yapılamıyor" + logger.addScreenCapture(capture()));
                            }
                        } else {
                            if (Get_playing().getAttribute("class").contains("ended") &&
                                    !Get_timeBar().getAttribute("aria-valuenow").equals("100.00")) {
                                logger.log(WARNING, "Sıradaki Videoya Geçiş Yapıldığını Linkten Manuel Olarak Kontrol Ediniz! " + logger.addScreenCapture(capture()) + driver.getCurrentUrl());
                            }
                        }
                    }
                    break;
                } else {
                    sayac++;
                    if (sayac == 20) {
                        logger.log(FAIL, "Video Player 20 Saniye Boyunca Otomatik Olarak Oynatılamadı" + logger.addScreenCapture(capture()));
                        break;
                    }
                }
                sleep(1000);
            }

        } else {
            logger.log(LogStatus.FAIL, "Player Yüklenemiyor");
        }
    }

}
