package ua.ek.steps;

import org.openqa.selenium.WebDriver;
import ua.ek.pages.HomePage;
import ua.ek.pages.registration.RegistrationPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.Helper;
import ua.ek.utils.IWaitTimes;

public class HomeStep extends BaseStep {

    private WebDriver driver;
    private Helper helper;

    public HomeStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
    }

    public HomePage goHomePage(){
        driver.get(getHomePage().getBaseUrl());
        return new HomePage(driver);
    }

    public RegistrationPage clickEnterLink() {
        if (getHomePage().getEnterLink() != null) {
            helper.clickWebElement(getHomePage().getEnterLink());
            return new RegistrationPage(driver);
        }
        return null;
    }

    public TabletsPage clickTabletsLink() {
        helper.clickWebElement(getHomePage().getComputersLink());
        helper.clickElementWithJS(getHomePage().getTabletsLink());

        return new TabletsPage(driver);
    }

    public TabletPage clickTabletLink() {
        helper.clickWebElement(getHomePage().getComputersLink());
        helper.clickElementWithJS(getHomePage().getTabletsLink());

        return new TabletPage(driver);
    }

    public AppleTabletsPage clickAppleTabletsCheckBox(){
        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getHomePage().getComputersLink());
        helper.clickElementWithJS(getHomePage().getComputersLink());
        helper.clickElementWithJS(getHomePage().getTabletsLink());

        helper.waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, getHomePage().getManufacturerApple());
        helper.clickElementWithJS(getHomePage().getManufacturerApple());

        return new AppleTabletsPage(driver);
    }
}
