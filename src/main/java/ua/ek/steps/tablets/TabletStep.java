package ua.ek.steps.tablets;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.IWaitTimes;
import ua.ek.utils.PageType;

public class TabletStep extends BaseStep {

    private WebDriver driver;
    private TabletPage tabletPage;

    public TabletStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        tabletPage = (TabletPage)getPage(PageType.TABLET_PAGE, driver);
    }

    public TabletStep goTabletPage() {
        getHelper().clickWebElement(getHomePage().getComputersMenuLink());
        getHelper().clickStalenessOfWebElementWithJS(getHomePage().getTabletsSubMenuLink());
        return this;
    }

    public TabletStep enterMinPrice(String minPrice) {
        getHelper().enterTextInTextField(tabletPage.getMinPriceField(), minPrice);
        return this;
    }

    public TabletStep enterMaxPrice(String maxPrice) {
        getHelper().enterTextInTextField(tabletPage.getMaxPriceField(), maxPrice);
        return this;
    }

    public TabletsListStep clickSubmitButton() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                tabletPage.getSubmitButton()).click();
        return new TabletsListStep(driver);
    }

    public TabletsListStep clickFixedPriceLink() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                tabletPage.getFixedPriceLink()).click();
        return new TabletsListStep(driver);
    }

    public TabletsListStep clickDisplayDiagonalLink() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                tabletPage.getDisplayDiagonalLink()).click();
        return new TabletsListStep(driver);
    }

    public TabletsListStep clickManufacturerLink() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS,
                tabletPage.getManufacturerLink()).click();
        return new TabletsListStep(driver);
    }
}