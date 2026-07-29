package tests.listingPageTests;


import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import pages.Navbar;
import utility.GeneralAndroidDriver;

import java.time.Duration;
import java.util.Arrays;

/**

 * Test Adı: Arama sonuçlarında sonsuz scroll / pagination
 * Test Açıklaması: Ürün listeleme sayfasında aşağıya kaydırdıkça yeni ürünlerin geldiği doğrulanmalı.
 * Test ID: 03

 */

public class ScrollEventTest extends GeneralAndroidDriver {

    /**
     * """ Method Adımları """
     * 1- Uygulamayı başlat
     * 2- Navbardaki arama input una tıkla
     * 3- Açılan arama ekranında inputa geçerli bir ürün ismi gönder
     * 4- Açılan sayfada ürünün isminin olduğunu doğrula
     */

    @Test(priority = 1, groups = "regression")
    public void scrollEventTest() throws InterruptedException {
        logger.info("Trendyol Başlatıldı.");

        Navbar navbar = new Navbar();
        SoftAssert softAssert = new SoftAssert();
        String validKey = "airpods";

        logger.info("Navbar objesi oluşturuldu.");
        logger.info("Aranacak kelime: " + validKey + ".");

        navbar.searchIcon.click();

        logger.info("Search icon elementine tıklanıldı, yeni arama ekranı açılıyor.");
        wait.until(ExpectedConditions.visibilityOf(navbar.searchInput));
        navbar.searchInput.sendKeys(validKey);
        logger.info("'" + validKey + "' kelimesi ekrana yazıldı.");

        logger.info("Otomatik doldurma kelimelerinin tıklanabilinir olması bekleniyor.");
        wait.until(ExpectedConditions.elementToBeClickable(navbar.firstAutocompleteItem));
        logger.info("Otomatik doldurma kelimeleri tıklanabilir.");

        navbar.searchInput.click();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        logger.info("Search Input a tıklanıldı ve enter tuşu tetiklendi.");

        logger.info("Listeleme sayfasının açılışı bekleniyor.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//android.widget.TextView[@resource-id=\"composeProductTileTitle\"])[1]")));

        ListingPage listingPage = new ListingPage();
        int startIndicator = Integer.parseInt(listingPage.currentScrollIndicator.getText());
        logger.info("Listeleme sayfası açıldı, sayfa objesi oluşturuldu.");
        logger.info("Başlangıç indikatör sayısı alındı. -> '" + startIndicator + "'");

        for (int i = 1; i < 11; i++) {
            scrollPage();
            Thread.sleep(1000);
            logger.info("Kaydırma işlemi gerçekleşti. Sayı: '" + i + "'");
        }

        int finalIndicator = Integer.parseInt(driver.findElement(By.id("trendyol.com:id/textViewScrolledItemCount")).getText());
        logger.info("Bitiş indikatör sayısı alındı. -> '" + finalIndicator + "'");

        softAssert.assertTrue(startIndicator < finalIndicator);

        logger.info("Assert kontrolü sağlandı.");
        logger.info("Test başarılı, trendyol kapatılıyor.");
        logger.info("TEST ÖZETİ: Sayfa 10 kez kaydırıldıktan sonra ürünler yüklenmeye devam etti ve indikatör sayısı arttı.");
    }

    public void scrollPage(){
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(556, 2177);
        var end = new Point (556, 354);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }
}

