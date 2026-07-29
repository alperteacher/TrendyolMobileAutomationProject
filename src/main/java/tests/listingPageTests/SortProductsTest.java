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

 * Test Adı: PLP üzerinde sıralama uygulanması
 * Test Açıklaması: Ürün listeleme sayfasına sıralama uygulandıktan sonra doğru bir şekilde ürünler listelenmeli.
 * Test ID: 02

 */

public class SortProductsTest extends GeneralAndroidDriver {

    /**
     * """ Method Adımları """
     * 1- Uygulamayı başlat
     * 2- Navbardaki arama input una tıkla
     * 3- Açılan arama ekranında inputa geçerli bir ürün ismi gönder
     * 4- Açılan sayfada ürünün isminin olduğunu doğrula
     */

    @Test(priority = 1, groups = "smoke")
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
        logger.info("Listeleme sayfası açıldı, sayfa objesi oluşturuldu.");

        listingPage.sortingButton.click();
        logger.info("Ürün sıralama butonuna tıklanıldı.");

        wait.until(ExpectedConditions.visibilityOf(listingPage.sortByLowToHighRadioButton));
        logger.info("Sıralama seçenekleri bekleniyor.");

        listingPage.sortByLowToHighRadioButton.click();
        logger.info("Artan fiyata göre sıralama yapıldı.");

        logger.info("Ürünlerin listelenmesi bekleniyor.");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//android.widget.TextView[@resource-id=\"composeProductTileTitle\"])[1]")));

        double firstItemPrice = Double.parseDouble(listingPage.firstItemPrice.getText());
        double secondItemPrice = Double.parseDouble(listingPage.secondItemPrice.getText());
        logger.info("Sayfa yüklendi, fiyatlar alındı. 1: '" + firstItemPrice + "' - 2: '" + secondItemPrice + "'");

        softAssert.assertTrue(firstItemPrice <= secondItemPrice);
        logger.info("Assert kontrolü sağlandı.");
        logger.info("Test başarılı, trendyol kapatılıyor.");
        logger.info("TEST ÖZETİ: Listeleme sayfasında ürünler başarı ile artan fiyata göre sıralandı. İlk fiyat, ikinci fiyattan küçük yada eşit.");
    }
}

