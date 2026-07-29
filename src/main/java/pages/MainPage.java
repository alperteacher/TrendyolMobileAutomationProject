package pages;

import utility.GeneralAndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends GeneralAndroidDriver {

    public MainPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }





    @FindBy(id = "trendyol.com:id/composeCarouselBannerWidget")
    public WebElement carouselBannerComponent;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"4/10\")")
    public WebElement bankkartCarouselIndicator;

}
