package org.trendyolautomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TrendyolExampleTest {

    public AndroidDriver driver;

    @BeforeTest
    public void initialization() throws MalformedURLException {
        // Otomasyon başlangıç adımları tanımlanacak
        // Server bağlantısı burada gerçekleşecek

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("16");
        options.setAppPackage("trendyol.com");
        options.setAppActivity("com.trendyol.common.splash.impl.ui.SplashActivity");
        options.setAppWaitActivity("*");
        options.setSkipUnlock(true);
        options.setNoReset(true);
        options.setAutomationName("UiAutomator2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }

    @Test
    public void testSteps() throws InterruptedException {
        // Test adımları burada tanımlanacak
        // Otomasyon kodları buraya yazılacak
        System.out.println("Driver çalıştı");

        Thread.sleep(30000);

        System.out.println("Timeout oldu, driver kapanıyor");
    }

    @AfterTest
    public void finalization(){
        // Test bitiş adımı burada gerçekleşecek
        // kapanış adımları tanımlanacak.
        driver.quit();

        System.out.println("Driver kapatıldı");
    }

}
