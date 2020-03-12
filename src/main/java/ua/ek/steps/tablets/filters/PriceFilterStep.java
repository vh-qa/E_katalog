package ua.ek.steps.tablets.filters;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.tablets.filters.PriceFilter;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.IWaitTimes;
import ua.ek.utils.PageType;

public class PriceFilterStep extends BaseStep {

    private PriceFilter priceFilter;

    public PriceFilterStep(WebDriver driver) {
        super(driver);
        priceFilter = (PriceFilter)getPage(PageType.PRICE_FILTER_PAGE, driver);
    }

    public PriceFilterStep enterMinPriceInMinPriceField(String minPrice) {
        getHelper().enterTextInTextField(priceFilter.getMinPriceInput(), minPrice);
        return this;
    }

    public PriceFilterStep enterMaxPriceInMinPriceField(String maxPrice) {
        getHelper().enterTextInTextField(priceFilter.getMaxPriceInput(), maxPrice);
        return this;
    }

    public PriceFilterStep clickShowButton() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                priceFilter.getShowButton()).click();
        return this;
    }
}