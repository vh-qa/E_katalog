package ua.ek.steps.tablets.manufacturers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.CustomWaits;
import ua.ek.utils.WaitUtils;

import static ua.ek.utils.IWaitTimes.*;

public class AppleTabletsStep extends BaseStep {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public AppleTabletsStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    public AppleTabletsStep goAppleTabletsPage(){
        getHelper().clickWebElement(getHomePage().getComputersLink());
        getHelper().clickElementWithJS(getHomePage().getTabletsLink());
        getHelper().clickElementWithJS(getAppleTabletsPage().getAppleManufacturerCheckBox());
        return this;
    }

    public AppleTabletsStep clickShowButton() {

        // Explicit wait
        getHelper().elementToBeClickable(getAppleTabletsPage().getShowButton(), FIVE_SECONDS);
        getHelper().clickElementWithJS(getAppleTabletsPage().getShowButton());

        return this;
    }

    public String getPageTitleText() {

//        // Fluent wait
        WebElement webElementFluentWay = waitUtils.fluentWait(By.xpath(getAppleTabletsPage().getPageTitleXpath()),
                FIVE_SECONDS, MILLISECOND_500);

//        // Custom wait
        WebElement webElementCustomWait = getHelper().waitUntilElementIsVisible(FIVE_SECONDS,
                                            By.xpath(getAppleTabletsPage().getPageTitleXpath()));
        WebDriverWait wait = new WebDriverWait(driver, FIVE_SECONDS);
        wait.until(CustomWaits.isElementContainsText(webElementCustomWait, "Apple"));

        return webElementCustomWait.getText();
    }
}