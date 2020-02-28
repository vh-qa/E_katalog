package ua.ek.pages.tablets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class TabletPage extends BasePage {
    @FindBy(xpath = ".//div/input[@name='minPrice_']")
    private WebElement minPriceField;

    @FindBy(xpath = ".//div/input[@name='maxPrice_']")
    private WebElement maxPriceField;

    @FindBy(xpath = ".//input[@type='submit' and @class='price-sub']")
    private WebElement submitButton;

    public TabletPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMinPriceField() {
        return minPriceField;
    }

    public WebElement getMaxPriceField() {
        return maxPriceField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}