package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utility.GAD;
import pages.Mainpage;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static pages.BeforeSchemas.*;
public class TrendyolExampleTest extends GAD {

    /*

        Seneryoya göre hangisi gerekli ise o before scheması kullanılır.

    */

    @BeforeMethod
    void exampleBeforeMethod(Method method) {METHOD_restartApplication(method,"exampleCase1");}

    /*
    @BeforeClass
    void exampleBeforeClass(Method method) {CLASS_restartApplication(method,"exampleMethod1");}
    */

    @Test(priority = 1)
    public void exampleCase1() {
        logger.info("Trendyol Başlatıldı.");

        Mainpage mp = new Mainpage();

        mp.searchIcon.click();
        mp.searchInput.sendKeys("Tisort");
        mp.firstAutocompleteItem.click();
        mp.firstItemInSearchPage.click();

    }

    @Test(priority = 2)
    public void exampleCase2() {
        logger.info("Trendyol Başlatıldı.");

        Mainpage mp = new Mainpage();

        mp.searchIcon.click();
        mp.searchInput.sendKeys("Pantolon");
        mp.firstAutocompleteItem.click();
        mp.firstItemInSearchPage.click();
    }
}
