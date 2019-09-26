package Finance_Widget;

import Utils.NTV_Driver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;

import java.io.IOException;

import static Elements.Finance_Widget.*;
import static Utils.Definitions.*;
import static java.lang.Thread.*;

public class Finance_Widget extends NTV_Driver {
    ExtentTest logger;

    @After
    public void Finance_Widget() throws InterruptedException, IOException {
        logger = extent.startTest("ntv.com.tr - Finans Widget Testi");
        widget();
    }

    private void widget() throws InterruptedException, IOException {
        if (checkElement(ntvFinanceWidget)) {
            logger.log(LogStatus.PASS, "Ana Sayfada Finans Widget'ı Gösteriliyor");
            Get_ntvFinanceBist().click();
            bist();
        } else {
            logger.log(LogStatus.FAIL, "Ana Sayfada Finans Widget'ı Gösterilemiyor: " + logger.addScreenCapture(capture()));
        }
    }

    private void bist() throws InterruptedException, IOException {
        System.out.println(driver.getTitle());
        if (driver.getTitle().equals("BIST Ekranı | NTV")) {
            logger.log(LogStatus.PASS, "Finans Widget'ından Bist Sayfasına Yönlendirme Başarılı");
            Get_ntvFinanceDollar().click();
            sleep(3000);

            dollar();
        } else {
            logger.log(LogStatus.FAIL, "Finans Widget'ından Bist Sayfasına Yönlendirme Yapılamadı: " + logger.addScreenCapture(capture()));
        }
    }

    private void dollar() throws InterruptedException, IOException {
        //   checkElement(ntvFinanceWidget);
        if (driver.getTitle().equals("Döviz Ekranı | NTV")) {
            logger.log(LogStatus.PASS, "Finans Widget'ından (Dolar), Döviz Sayfasına Yönlendirme Başarılı");
            Get_ntvFinanceEuro().click();
            sleep(3000);

            euro();
        } else {
            logger.log(LogStatus.FAIL, "Finans Widget'ından (Dolar), Dövviz Sayfasına Yönlendirme Yapılamadı: " + logger.addScreenCapture(capture()));
        }
    }

    private void euro() throws InterruptedException, IOException {
        // checkElement(ntvFinanceWidget);
        if (driver.getTitle().equals("Döviz Ekranı | NTV")) {
            logger.log(LogStatus.PASS, "Finans Widget'ından(Euro), Döviz Sayfasına Yönlendirme Başarılı");
            Get_ntvFinanceGold().click();
            sleep(3000);
            gold();
        } else {
            logger.log(LogStatus.FAIL, "Finans Widget'ından (Euro), Dövviz Sayfasına Yönlendirme Yapılamadı: " + logger.addScreenCapture(capture()));
        }
    }

    private void gold() throws IOException {
        //  checkElement(ntvFinanceWidget);
        if (driver.getTitle().equals("Altın Ekranı | NTV")) {
            logger.log(LogStatus.PASS, "Finans Widget'ından Altın Sayfasına Yönlendirme Başarılı");
        } else {
            logger.log(LogStatus.FAIL, "Finans Widget'ından Altın Sayfasına Yönlendirme Yapılamadı: " + logger.addScreenCapture(capture()));
        }
    }
}
