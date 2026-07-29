package tests.searchTests;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import pages.Navbar;
import utility.GeneralAndroidDriver;

import org.testng.annotations.Test;


/**

 * Test Adı: Geçerli bir anahtar kelime ile arama yapılması
 * Test Açıklaması: Geçerli bir kelimenin arama yapıldıktan sonra listeleme sayfasında bulunması test edilir.
 * Test ID: 01

 */

public class SearchWithValidKeyTest extends GeneralAndroidDriver {

    /**
     * """ Method Adımları """
     * 1- Uygulamayı başlat
     * 2- Navbardaki arama input una tıkla
     * 3- Açılan arama ekranında inputa geçerli bir ürün ismi gönder
     * 4- Açılan sayfada ürünün isminin olduğunu doğrula
     */

    @Test(priority = 1, groups = "smoke")
    public void searchWithValidKeyTest() {
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

        softAssert.assertTrue(listingPage.firstItemInSearchPage.getText().toLowerCase().contains(
                validKey.toLowerCase()), "Aranan kelime ürün listeleme sayfası içerisinde yok.");
        logger.info("Assert kontrolü sağlandı.");
        logger.info("Test başarılı, trendyol kapatılıyor.");
        logger.info("TEST ÖZETİ: Geçerli kelime araması başarı ile gerçekleşti, listeleme sayfası içerisinde ilk ürün ismi aranan kelimeyi taşıyor.");
    }
}



















