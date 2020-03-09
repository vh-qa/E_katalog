package ua.ek.steps.tablets.filters;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.IWaitTimes;

public class PriceFilterStep extends BaseStep {

    public PriceFilterStep(WebDriver driver) {
        super(driver);
    }

    public PriceFilterStep enterMinPriceInMinPriceField(String minPrice) {
        getHelper().enterTextInTextField(getPriceFilter().getMinPriceInput(), minPrice);
        return this;
    }

    public PriceFilterStep enterMaxPriceInMinPriceField(String maxPrice) {
        getHelper().enterTextInTextField(getPriceFilter().getMaxPriceInput(), maxPrice);
        return this;
    }

    public PriceFilterStep clickShowButton() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getPriceFilter().getShowButton()).click();
        return this;
    }
}