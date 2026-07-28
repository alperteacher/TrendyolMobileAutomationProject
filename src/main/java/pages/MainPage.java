package pages;

import utility.GAD;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends GAD {

    public MainPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Arama")
    public WebElement searchIcon;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"editTextSearchView\"]")
    public WebElement searchInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"trendyol.com:id/constraintLayoutItemSearchAutoComplete\").instance(0)")
    public WebElement firstAutocompleteItem;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"composeProductTileTitle\"])[1]")
    public WebElement firstItemInSearchPage;

    @FindBy(id = "trendyol.com:id/composeCarouselBannerWidget")
    public WebElement carouselBannerComponent;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"4/10\")")
    public WebElement bankkartCarouselIndicator;

}
