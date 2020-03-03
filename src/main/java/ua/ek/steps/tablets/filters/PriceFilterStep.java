package ua.ek.steps.tablets.filters;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.tablets.filters.PriceFilter;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;
import ua.ek.utils.IWaitTimes;

public class PriceFilterStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public PriceFilterStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public PriceFilter enterMinPriceInMinPriceField(String minPrice) {
        helper.enterTextInTextField(getPriceFilter().getMinPriceInput(), minPrice);
        return new PriceFilter(driver);
    }

    public PriceFilter enterMaxPriceInMinPriceField(String maxPrice) {
        helper.enterTextInTextField(getPriceFilter().getMaxPriceInput(), maxPrice);
        return new PriceFilter(driver);
    }

    public PriceFilter clickShowButton() {
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getPriceFilter().getShowButton()).click();
        return new PriceFilter(driver);
    }
}