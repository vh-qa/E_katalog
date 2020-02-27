package ua.ek.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.ek.utils.WaitUtils;

public abstract class BasePage {

    protected final static int THREE_SECONDS = 3;
    protected final static int FIVE_SECONDS = 5;
    protected final static int TEN_SECONDS = 10;
    protected final static int FIFTEEN_SECONDS = 15;
    protected final static int TWENTY_SECONDS = 20;

    protected final static int MILLISECOND_100 = 100;
    protected final static int MILLISECOND_500 = 500;

    protected WebDriver driver;

    WaitUtils waitUtils;

    @FindBy(xpath = "//span[@class='wu_entr']//em")
    private WebElement enterLink; // "Войти" link

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebElement getEnterLink() {
        if (isWebElementDisplayed(enterLink)) {
            return enterLink;
        }
        return null;
    }

    protected String getWebElementText(By by){
        return waitUntilElementIsVisible(FIVE_SECONDS, by).getText().trim();
    }

    protected String getWebElementText(WebElement webElement){
        return waitUntilElementIsVisible(FIVE_SECONDS, webElement).getText().trim();
    }

    protected void enterTextInTextField(WebElement textField, String inputText) {
        waitUntilElementIsVisible(FIVE_SECONDS, textField);
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }

    protected void clickWebElement(WebElement webElement){
        waitUntilElementIsVisible(FIVE_SECONDS, webElement);
        webElement.click();
    }

    protected WebElement waitUntilElementIsVisible(Integer waitTime, WebElement webElement) {
        return waitUtils.visibilityOf(webElement, waitTime);
    }

    protected WebElement waitUntilElementIsVisible(Integer waitTime, By by) {
        WebElement webElement = driver.findElement(by);
        return waitUtils.visibilityOf(webElement, waitTime);
    }

    protected WebElement presenceOfElementLocated(Integer waitTime, WebElement webElement, By by) {
        return waitUtils.presenceOfElementLocated(by, waitTime);
    }

    protected WebElement elementToBeClickable(Integer waitTime, WebElement webElement){
        return waitUtils.elementToBeClickable(webElement, waitTime);
    }

    protected WebElement fluentWait(By by, Integer waitTime, Integer polling){
        return waitUtils.fluentWait(by, waitTime, polling);
    }

    protected boolean isWebElementDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    protected boolean isWebElementSelected(WebElement webElement) {
        return webElement.isSelected();
    }

    protected boolean isWebElementEnabled(WebElement webElement) {
        return webElement.isEnabled();
    }

    protected void clickWebElementByXpath(String xpath) {
        driver
                .findElement(By.xpath(xpath))
                .click();
    }

    protected void clickElementWithJS(WebElement webElement){
        waitUtils.elementToBeSelected(webElement, THREE_SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }
}