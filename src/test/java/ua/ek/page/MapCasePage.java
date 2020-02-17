package ua.ek.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.utils.ITimeOfWait;

public class MapCasePage extends BasePage {

    @FindBy(xpath = ".//div/input[@name='minPrice_']")
    private WebElement minPriceField;

    @FindBy(xpath = ".//div/input[@name='maxPrice_']")
    private WebElement maxPriceField;

    @FindBy(xpath = ".//input[@type='submit' and @class='price-sub']")
    private WebElement submitButton;

    public MapCasePage(WebDriver driver) {
        super(driver);
    }

    public MapCasePage enterMinPrice(String minPrice) {
        enterTextInTextField(minPriceField, minPrice);
        return this;
    }

    public MapCasePage enterMaxPrice(String maxPrice) {
        enterTextInTextField(maxPriceField, maxPrice);
        return this;
    }

    public MapCasesList submitButtonClick(){
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, submitButton);
        submitButton.click();
        return new MapCasesList(driver);
    }
}
