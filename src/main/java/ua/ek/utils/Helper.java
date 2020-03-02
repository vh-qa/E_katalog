package ua.ek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

    private WebDriver driver;
    private WaitUtils waitUtils;

    public Helper(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    public void enterTextInTextField(WebElement textField, String inputText) {
        waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, textField);
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }

    public String getWebElementText(By by) {
        return waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, by).getText().trim();
    }

    public String getWebElementText(WebElement webElement) {
        return waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, webElement).getText().trim();
    }

    public void clickWebElement(WebElement webElement) {
        waitUntilElementIsVisible(IWaitTimes.FIVE_SECONDS, webElement);
        webElement.click();
    }

    public WebElement waitUntilElementIsVisible(Integer waitTime, WebElement webElement) {
        return waitUtils.visibilityOf(webElement, waitTime);
    }

    public WebElement waitUntilElementIsVisible(Integer waitTime, By by) {
        WebElement webElement = driver.findElement(by);
        return waitUtils.visibilityOf(webElement, waitTime);
    }

    public Boolean visibilityOf(Integer waitTime, WebElement webElement) {
        if (waitUtils.visibilityOf(webElement, waitTime) != null) {
            return true;
        }
        return false;
    }

    public Boolean visibilityOfElementLocated(By by, int timeout) {
        if (waitUtils.visibilityOfElementLocated(by, timeout) != null) {
            return true;
        }
        return false;
    }

    public Boolean elementToBeSelected(WebElement webElement, Integer waitTime) {
        return waitUtils.elementToBeSelected(webElement, waitTime);
    }

    public Boolean presenceOfElementLocated(By by, int timeout) {
        if (waitUtils.presenceOfElementLocated(by, timeout) != null) {
            return true;
        }
        return false;
    }

    public WebElement elementToBeClickable(WebElement webElement, Integer timeout) {
        return waitUtils.elementToBeClickable(webElement, timeout);
    }

    public Boolean isWebElementDisplayed(WebElement webElement) {
        return webElement.isDisplayed();
    }

    public void clickElementWithJS(WebElement webElement) {
        elementToBeSelected(webElement, IWaitTimes.THREE_SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public boolean getCheckBoxStatus(WebElement webElement) {
        if (webElement.getAttribute("type").equals("checkbox")) {
            if (webElement.getAttribute("value").trim().toLowerCase().equals("y")) {
                return true;
            }
        }

        return false;
    }

    public static int convertDoubleToInt(double value) {
        return (int) value;
    }

    public static String convertDoubleToString(double value) {
        return String.valueOf(convertDoubleToInt(value));
    }

    public static String getProperty(String propertyFileName, String propertyName){
        return PropertyReader
                .from(propertyFileName, propertyName)
                .getProperty(propertyName);
    }
}

