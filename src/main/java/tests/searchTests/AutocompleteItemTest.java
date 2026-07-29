package tests.searchTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import pages.ListingPage;
import pages.Navbar;
import utility.GeneralAndroidDriver;

import org.testng.annotations.Test;


/**

 * Test Adı: Otomatik öneriden seçim yaparak arama
 * Test Açıklaması: Arama kutusu içerisine yazılan metinlerin otomatik şekilde tamamlanması test edilir.
 * Test ID: 02

 */

public class AutocompleteItemTest extends GeneralAndroidDriver {

    /**
     * """ Method Adımları """
     * 1- Uygulamayı başlat
     * 2- Navbardaki arama input una tıkla
     * 3- Açılan arama ekranında inputa geçerli bir ürün ismi gönder
     * 4- Otomatik doldurma kelimesinin gelmesini bekle ve tıkla
     * 5- Açılan sayfadaki ürün ismi autocomplete item ürün ismi ile tutuşmalı
     */

    @Test(priority = 1, groups = "regression")
    public void searchWithValidKeyTest() {
        logger.info("Trendyol Başlatıldı.");

        Navbar navbar = new Navbar();
        SoftAssert softAssert = new SoftAssert();
        String validKey = "oyunc";

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

        String autocompleteItemText = navbar.firstAutocompleteItem.getText();
        navbar.firstAutocompleteItem.click();
        logger.info("İlk otomatik doldurma kelimesine tıklanıldı ve kelime ismi değişkene atandı.");
        logger.info("Listeleme sayfasının açılışı bekleniyor.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//android.widget.TextView[@resource-id=\"composeProductTileTitle\"])[1]")));

        ListingPage listingPage = new ListingPage();
        logger.info("Listeleme sayfası açıldı, sayfa objesi oluşturuldu.");

        softAssert.assertTrue(listingPage.firstItemInSearchPage.getText().toLowerCase().contains(
                autocompleteItemText.toLowerCase()), "Aranan kelime ürün listeleme sayfası içerisinde yok.");
        logger.info("Assert kontrolü sağlandı.");
        logger.info("Test başarılı, trendyol kapatılıyor.");
        logger.info("TEST ÖZETİ: Otomatik doldurma elementine tıklanıldı ve element listeleme sayfasında geçiyor.");
    }
}
