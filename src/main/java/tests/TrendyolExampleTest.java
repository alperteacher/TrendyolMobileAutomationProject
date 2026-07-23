package tests;

import utility.GAD;
import pages.Mainpage;

import org.testng.annotations.Test;

public class TrendyolExampleTest extends GAD {

    @Test
    public void testSteps() throws InterruptedException {
        // Test adımları burada tanımlanacak
        // Otomasyon kodları buraya yazılacak
        logger.info("Trendyol Başlatıldı.");
        Thread.sleep(15000);

        Mainpage mp = new Mainpage();

        mp.genderWomanButton.click();
        mp.notificationAllowButton.click();
        mp.searchIcon.click();
        mp.searchInput.sendKeys("Tisort");
        mp.firstAutocompleteItem.click();
        mp.firstItemInSearchPage.click();

        logger.info("Trendyol Kapatıldı.");

        Thread.sleep(7000);
    }
}
