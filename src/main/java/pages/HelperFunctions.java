package pages;

import utility.GAD;

public class HelperFunctions extends GAD {

    public static void restartApplication() throws InterruptedException {
        logger.info("Uygulama kapatılıyor, temiz başlangıç yapılıyor.");
        driver.terminateApp("trendyol.com");
        driver.activateApp("trendyol.com");
        logger.info("Uygulama açılıyor.");

        Thread.sleep(15000);

        logger.info("Temiz başlangıç yapıldı.");
    }
}
