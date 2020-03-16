package ua.ek.steps;

import org.openqa.selenium.WebDriver;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.IWaitTimes;

public class HomeStep extends BaseStep {

    private WebDriver driver;

    public HomeStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomeStep goHomePage() {
        driver.get(getHomePage().getBaseUrl());
        return this;
    }

    public HomeStep clickEnterLink() {
        getHelper().clickWebElement(getHomePage().getEnterLink());
        return this;
    }

    public HomeStep clickTabletsLink() {
        getHelper().clickWebElement(getHomePage().getComputersMenuLink());
        getHelper().clickStalenessOfWebElementWithJS(getHomePage().getTabletsSubMenuLink());
        return this;
    }

    public HomeStep clickTabletLink() {
        getHelper().clickWebElement(getHomePage().getComputersMenuLink());
        getHelper().clickStalenessOfWebElementWithJS(getHomePage().getTabletsSubMenuLink());
        return this;
    }

    public HomeStep clickAppleTabletsCheckBox() {
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getHomePage().getComputersMenuLink());
        getHelper().clickStalenessOfWebElementWithJS(getHomePage().getComputersMenuLink());
        getHelper().clickStalenessOfWebElementWithJS(getHomePage().getTabletsSubMenuLink());

        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getHomePage().getManufacturerApple());
        getHelper().clickStalenessOfWebElementWithJS(getHomePage().getManufacturerApple());

        return this;
    }
}