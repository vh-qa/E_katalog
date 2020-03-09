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

    public HomeStep goHomePage(){

        driver.get(getHomePage().getBaseUrl());
        return this;
    }

    public HomeStep clickEnterLink() {
            getHelper().clickWebElement(getHomePage().getEnterLink());
            return this;
    }

    public HomeStep clickTabletsLink() {
        getHelper().clickWebElement(getHomePage().getComputersLink());
        getHelper().clickElementWithJS(getHomePage().getTabletsLink());
        return this;
    }

    public HomeStep clickTabletLink() {
        getHelper().clickWebElement(getHomePage().getComputersLink());
        getHelper().clickElementWithJS(getHomePage().getTabletsLink());
        return this;
    }

    public HomeStep clickAppleTabletsCheckBox(){
        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getHomePage().getComputersLink());
        getHelper().clickElementWithJS(getHomePage().getComputersLink());
        getHelper().clickElementWithJS(getHomePage().getTabletsLink());

        getHelper().waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getHomePage().getManufacturerApple());
        getHelper().clickElementWithJS(getHomePage().getManufacturerApple());

        return this;
    }
}