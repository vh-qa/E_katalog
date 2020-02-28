package ua.ek.steps.tablets.manufacturers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ek.pages.tablets.manufacturers.AppleTabletsPage;
import ua.ek.steps.base.BaseStep;
import ua.ek.utils.CustomWaits;
import ua.ek.utils.Helper;
import ua.ek.utils.WaitUtils;

import static ua.ek.utils.IWaitTimes.*;

public class AppleTabletsStep  extends BaseStep {

    private WebDriver driver;
    private Helper helper;
    private WaitUtils waitUtils;
    private CustomWaits customWaits;

    public AppleTabletsStep(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new Helper(driver);
        waitUtils = new WaitUtils(driver);
        customWaits = new CustomWaits();
    }

    public AppleTabletsPage goAppleTabletsPage(WebDriver driver){
        return goHomePage(driver).clickAppleTabletsCheckBox();
    }

    public AppleTabletsPage clickShowButton() {

        // Explicit wait
        helper.elementToBeClickable(getAppleTabletsPage().getShowButton(), FIVE_SECONDS);
        helper.clickElementWithJS(getAppleTabletsPage().getShowButton());

        return new AppleTabletsPage(driver);
    }

    public String getPageTitleText() {

//        // Fluent wait
        WebElement webElementFluentWay = waitUtils.fluentWait(By.xpath(getAppleTabletsPage().getPageTitleXpath()),
                FIVE_SECONDS, MILLISECOND_500);

//        // Custom wait
        WebElement webElementCustomWait = helper.waitUntilElementIsVisible(FIVE_SECONDS,
                                            By.xpath(getAppleTabletsPage().getPageTitleXpath()));
        WebDriverWait wait = new WebDriverWait(driver, FIVE_SECONDS);
        wait.until(CustomWaits.isElementContainsText(webElementCustomWait, "Apple"));

        return webElementCustomWait.getText();
    }
}
