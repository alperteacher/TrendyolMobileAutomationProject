package utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static pages.HelperFunctions.restartApplication;

public class GAD {
    public static AndroidDriver driver;
    public static WebDriverWait wait;

    public static Logger logger = LogManager.getLogger(GAD.class);

    @BeforeSuite
    public void initialization() throws MalformedURLException, InterruptedException {
        logger.info("Driver başlatılıyor.");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("16");
        options.setCapability("appium:forceAppLaunch", true);
        options.setAppPackage("trendyol.com");
        options.setAppWaitActivity("*");
        options.setSkipUnlock(true);
        options.setNoReset(true);
        options.setAutomationName("UiAutomator2");

        logger.info("Opsiyonlar tanımlandı.");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        logger.info("Driver başlatıldı.");
        logger.info("Trendyol'a yönleniliyor");

        restartApplication();
    }

    @AfterSuite
    public void finalization() throws InterruptedException {
        logger.info("Trendyol Kapatılıyor.");
        logger.info("Driver Kapatılıyor.");

        Thread.sleep(15000);

        if (!(driver == null)) {
            driver.quit();

            logger.info("Driver Kapatıldı.");
        }
    }
}
