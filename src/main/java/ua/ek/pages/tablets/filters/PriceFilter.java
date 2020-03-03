package ua.ek.pages.tablets.filters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class PriceFilter extends BasePage {

    @FindBy(xpath = ".//input[@id='minPrice_']")
    private WebElement minPriceInput;

    @FindBy(xpath = ".//input[@id='maxPrice_']")
    private WebElement maxPriceInput;

    @FindBy(xpath = ".//*[@id='tt-info']/a")
    private WebElement showButton;

    public PriceFilter(WebDriver driver) {
        super(driver);
    }

    public WebElement getMinPriceInput() {
        return minPriceInput;
    }

    public WebElement getMaxPriceInput() {
        return maxPriceInput;
    }

    public WebElement getShowButton() {
        return showButton;
    }
}
