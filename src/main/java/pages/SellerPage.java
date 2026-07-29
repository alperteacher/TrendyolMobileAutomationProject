package pages;

import utility.GeneralAndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SellerPage extends GeneralAndroidDriver {

    public SellerPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"searchVerticalProductCardContent\").instance(0)")
    public WebElement firstItemCardContent;

}
