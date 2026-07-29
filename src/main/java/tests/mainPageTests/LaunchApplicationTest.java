package tests.mainPageTests;

import pages.MainPage;
import utility.GeneralAndroidDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

    /**

     * Test Adı: Trendyol Başlatma Testi
     * Test Açıklaması: Trendyol uygulaması başlatılır ve kullanıcının anasayfaya geldiği doğrulanır.
     * TestID: 01

     */

public class LaunchApplicationTest extends GeneralAndroidDriver {

    /**
     * """ Method Adımları """
     * 1- Uygulama başlatılır
     * 2- Carousel Banner ekranda gözüktüğü doğrulanır
    */

    @Test(priority = 1, groups = "smoke")
    public void launchApplication() {
        logger.info("Trendyol Başlatıldı.");

        MainPage mp = new MainPage();
        SoftAssert softAssert = new SoftAssert();

        logger.info("Ana sayfa objesi oluşturuldu.");
        logger.info("Carousel Banner Component elementi bekleniyor.");
        wait.until(ExpectedConditions.visibilityOf(mp.carouselBannerComponent));

        logger.info("Element bulundu, doğrulama yapılıyor.");
        softAssert.assertTrue(mp.carouselBannerComponent.isDisplayed(), "Anasayfada banner görünür değil.");

        logger.info("Assert kontrolü başarılı.");
        logger.info("Test başarılı, trendyol kapatılıyor.");
        logger.info("TEST ÖZETİ: Uygulama doğru bir şekilde başlatıldı. Anasayfa elementleri yüklendi.");
    }
}
