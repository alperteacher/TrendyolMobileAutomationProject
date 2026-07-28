package tests.mainPageTests;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import pages.ListingPage;
import utility.GAD;
import pages.MainPage;
import pages.SellerPage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Arrays;

/**

     * Test Adı: Trendyol Kampanya İşlevsellik Testi
     * Test Açıklaması: Trendyol uygulaması başlatılır ve kampanyaya tıklanılarak, açılan sayfa doğrulanır.

     */

public class BannerActivityTest extends GAD {

    /**
     * """ Method Adımları """
     * 1- Uygulama başlatılır,
     * 2- Anasayfada en üstteki Carousel Banner 7. ye gelene kadar beklenir,
     * 3- Banner'a tıklanır,
     * 4- Açılan seller sayfasında, ürün kartlarının içerikleri geldiği doğrulanır.
     */

    @Test(priority = 1, groups = "regression")
    public void bannerActivityTest() {
        logger.info("Trendyol Başlatıldı.");

        MainPage mainPage = new MainPage();
        SoftAssert softAssert = new SoftAssert();

        logger.info("Ana sayfa objesi oluşturuldu.");

        wait.until(ExpectedConditions.visibilityOf(mainPage.bankkartCarouselIndicator));
        mainPage.bankkartCarouselIndicator.click();

        logger.info("Banner & 4. indikatör: Bankkart kampanyasına tıklanıldı.");
        logger.info("Kampanya sayfasına yönlendirildi.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"VerticalProductCard\").instance(0)")));

        ListingPage listingPage = new ListingPage();
        logger.info("Listeleme sayfası objesi oluşturuldu.");

        softAssert.assertTrue(listingPage.firstItemCard.isDisplayed(), "Element sayfada gözükmedi.");
        logger.info("Assert kontrolü sağlandı.");
        logger.info("Test başarılı, trendyol kapatılıyor.");
    }
}
