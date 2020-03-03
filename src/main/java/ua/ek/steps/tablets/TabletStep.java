package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsListPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;
import ua.ek.utils.IWaitTimes;

public class TabletStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public TabletStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public TabletPage goTabletPage(WebDriver driver) {
        helper.clickWebElement(getHomePage().getComputersLink());
        helper.clickElementWithJS(getHomePage().getTabletsLink());
        return new TabletPage(driver);
    }

    public TabletPage enterMinPrice(String minPrice) {
        helper.enterTextInTextField(getTabletPage().getMinPriceField(), minPrice);
        return new TabletPage(driver);
    }

    public TabletPage enterMaxPrice(String maxPrice) {
        helper.enterTextInTextField(getTabletPage().getMaxPriceField(), maxPrice);
        return new TabletPage(driver);
    }

    public TabletsListPage submitButtonClick() {
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getTabletPage().getSubmitButton()).click();
        return new TabletsListPage(driver);
    }

    public TabletsListPage clickFixedPriceLink() {
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getTabletPage().getFixedPriceLink()).click();
        return new TabletsListPage(driver);
    }

    public TabletsListPage clickDisplayDiagonalLink() {
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getTabletPage().getDisplayDiagonalLink()).click();
        return new TabletsListPage(driver);
    }

    public TabletsListPage clickManufacturerLink() {
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                getTabletPage().getManufacturerLink()).click();
        return new TabletsListPage(driver);
    }
}