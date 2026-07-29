package tests.searchTests;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import pages.Navbar;
import utility.GeneralAndroidDriver;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;


/**

 * Test Adı: Geçerli bir anahtar kelime ile arama yapılması
 * Test Açıklaması: Geçersiz bir şekilde aranan kelimenin, aranan ürün bulunamadı sayfasına yönlendirmesi beklenir.
 * Test ID: 03

 */

public class SearchWithInvalidKeyTest extends GeneralAndroidDriver {

    /**
     * """ Method Adımları """
     * 1- Uygulamayı başlat
     * 2- Navbardaki arama input una tıkla
     * 3- Açılan arama ekranında inputa geçersiz bir ürün ismi gönder
     * 4- Açılan sayfada ürün bulunamadı metni olduğu doğrula
     */

    @Test(priority = 1, groups = "regression")
    public void searchWithValidKeyTest() throws InterruptedException {
        logger.info("Trendyol Başlatıldı.");

        Navbar navbar = new Navbar();
        SoftAssert softAssert = new SoftAssert();
        String validKey = "xa1sx5a8se4";

        logger.info("Navbar objesi oluşturuldu.");
        logger.info("Aranacak kelime: " + validKey + ".");

        navbar.searchIcon.click();

        logger.info("Search icon elementine tıklanıldı, yeni arama ekranı açılıyor.");
        wait.until(ExpectedConditions.visibilityOf(navbar.searchInput));
        navbar.searchInput.sendKeys(validKey);
        logger.info("'" + validKey + "' kelimesi ekrana yazıldı.");

        navbar.searchInput.click();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        logger.info("Search Input a tıklanıldı ve enter tuşu tetiklendi.");

        logger.info("Listeleme sayfasının açılışı bekleniyor.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("trendyol.com:id/textViewInfo")));
        ListingPage listingPage = new ListingPage();
        logger.info("Listeleme sayfası açıldı, sayfa objesi oluşturuldu.");

        softAssert.assertTrue(listingPage.noFoundText.getText().toLowerCase().contains(
                validKey.toLowerCase()), "Aranan kelime ürün listeleme sayfası içerisinde yok.");

        logger.info("Assert kontrolü sağlandı.");
        logger.info("Test başarılı, trendyol kapatılıyor.");
        logger.info("TEST ÖZETİ: Geçersiz kelime araması başarı ile gerçekleşti, ürün bulunamadı listeleme sayfasına yönelndirilem yapıldı.");
    }
}
