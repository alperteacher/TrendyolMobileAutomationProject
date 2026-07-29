package pages;

import org.openqa.selenium.support.FindBy;
import utility.GeneralAndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ListingPage extends GeneralAndroidDriver {

    public ListingPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"VerticalProductCard\").instance(0)")
    public WebElement firstItemCard;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"composeProductTileTitle\"])[1]")
    public WebElement firstItemInSearchPage;

    @FindBy(id = "trendyol.com:id/textViewInfo")
    public WebElement noFoundText;

    @FindBy(id= "trendyol.com:id/textViewScrolledItemCount")
    public WebElement currentScrollIndicator;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"trendyol.com:id/textViewOpenFilterSearchFilterSortingName\" and @text=\"Sırala\"]")
    public WebElement sortingButton;

    @FindBy(xpath = "//android.widget.RadioButton[@resource-id=\"trendyol.com:id/radioButtonSortingTypeItem\" and @text=\"En Düşük Fiyat\"]")
    public WebElement sortByLowToHighRadioButton;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"corePriceFinalPrice\"])[1]")
    public WebElement firstItemPrice;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"corePriceFinalPrice\"])[2]")
    public WebElement secondItemPrice;

}
