package ua.ek.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final static int THREE_SECONDS = 3;
    protected final static int FIVE_SECONDS = 5;
    protected final static int TEN_SECONDS = 10;
    protected final static int FIFTEEN_SECONDS = 15;
    protected final static int TWENTY_SECONDS = 20;

    protected final static int MILLISECOND_100 = 100;
    protected final static int MILLISECOND_500 = 500;

    protected WebDriver driver;

    @FindBy(xpath = "//span[@class='wu_entr']//em")
    private WebElement enterLink; // "Войти" link

    public BasePage(WebDriver driver) {
        this.driver = driver;
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
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.withMessage("Element was not found");
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement waitUntilElementIsVisible(Integer waitTime, By by) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        WebElement webElement = driver.findElement(by);
        wait.withMessage("Element was not found");
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement presenceOfElementLocated(Integer waitTime, WebElement webElement, By by) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
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

    protected void executeWebElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    protected boolean isWebElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}