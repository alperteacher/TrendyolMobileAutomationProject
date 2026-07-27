package pages;

import utility.GAD;

import java.lang.reflect.Method;

public class BeforeSchemas extends GAD {
    public static void METHOD_restartApplication(Method method, String name) {
        if (method.getName().equals(name)) {
            return;
        }

        logger.info("Uygulama kapatılıyor, temiz başlangıç yapılıyor.");
        driver.terminateApp("trendyol.com");
        driver.activateApp("trendyol.com");
        logger.info("Uygulama açılıyor.");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logger.info("Temiz başlangıç yapıldı.");
    }

    public static void CLASS_restartApplication(Method method, String name) {
        if (method.getName().equals(name)) {
            return;
        }

        logger.info("Uygulama kapatılıyor, temiz başlangıç yapılıyor.");
        driver.terminateApp("trendyol.com");
        driver.activateApp("trendyol.com");
        logger.info("Uygulama açılıyor.");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logger.info("Temiz başlangıç yapıldı.");
    }
}
