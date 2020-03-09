package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.IWaitTimes;

public class TabletStep extends BaseStep {

    private WebDriver driver;

    public TabletStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public TabletStep goTabletPage() {
        getHelper().clickWebElement(getHomePage().getComputersLink());
        getHelper().clickElementWithJS(getHomePage().getTabletsLink());
        return this;
    }

    public TabletStep enterMinPrice(String minPrice) {
        getHelper().enterTextInTextField(getTabletPage().getMinPriceField(), minPrice);
        return this;
    }

    public TabletStep enterMaxPrice(String maxPrice) {
        getHelper().enterTextInTextField(getTabletPage().getMaxPriceField(), maxPrice);
        return this;
    }

    public TabletsListStep submitButtonClick() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getTabletPage().getSubmitButton()).click();
        return new TabletsListStep(driver);
    }

    public TabletsListStep clickFixedPriceLink() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getTabletPage().getFixedPriceLink()).click();
        return new TabletsListStep(driver);
    }

    public TabletsListStep clickDisplayDiagonalLink() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getTabletPage().getDisplayDiagonalLink()).click();
        return new TabletsListStep(driver);
    }

    public TabletsListStep clickManufacturerLink() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getTabletPage().getManufacturerLink()).click();
        return new TabletsListStep(driver);
    }
}