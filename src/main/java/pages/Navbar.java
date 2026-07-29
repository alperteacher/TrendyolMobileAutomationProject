package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.GeneralAndroidDriver;

public class Navbar extends GeneralAndroidDriver {

    public Navbar() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Arama")
    public WebElement searchIcon;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"editTextSearchView\"]")
    public WebElement searchInput;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"trendyol.com:id/constraintLayoutItemSearchAutoComplete\").instance(0)")
    public WebElement firstAutocompleteItem;
}
