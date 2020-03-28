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
        waitUntilElementIsVisible(IWaitTimes.TEN_SECONDS, textField);
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }

    public String getTextFromWebElement(By by) {
        return waitUntilElementIsVisible(IWaitTimes.TEN_SECONDS, by).getText().trim();
    }

    public String getTextFromWebElement(WebElement webElement) {
        return waitUntilElementIsVisible(IWaitTimes.TEN_SECONDS, webElement).getText().trim();
    }

    public String getTextFromStalenessOfWebElement(WebElement webElement) {
        if(waitUntilElementIsStalenessOf(webElement, IWaitTimes.TEN_SECONDS)) {
            return webElement.getText().trim();
        }else{
            waitUntilElementIsVisible(IWaitTimes.TEN_SECONDS, webElement);
            return webElement.getText().trim();
        }
    }

    public void clickWebElement(WebElement webElement) {
        waitUntilElementIsVisible(IWaitTimes.TEN_SECONDS, webElement);
        webElement.click();
    }

    public void clickStalenessOfWebElement(WebElement webElement) {
        waitUntilElementIsStalenessOf(webElement, IWaitTimes.TEN_SECONDS);
        webElement.click();
    }

    public WebElement waitUntilElementIsVisible(int waitTime, WebElement webElement) {
        return waitUtils.visibilityOf(webElement, waitTime);
    }

    public WebElement waitUntilElementIsVisible(int waitTime, By by) {
        WebElement webElement = driver.findElement(by);
        return waitUtils.visibilityOf(webElement, waitTime);
    }

    public Boolean waitUntilElementIsStalenessOf(WebElement webElement, int waitTime) {
        return stalenessOf(webElement, waitTime);
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

    public Boolean elementToBeSelected(WebElement webElement, int waitTime) {
        return waitUtils.elementToBeSelected(webElement, waitTime);
    }

    public WebElement visibilityOf(WebElement webElement, int waitTime){
        return waitUtils.visibilityOf(webElement, waitTime);
    }

    public Boolean stalenessOf(WebElement webElement, int waitTime) {
        return waitUtils.stalenessOf(webElement, waitTime);
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

    public void clickStalenessOfWebElementWithJS(WebElement webElement) {
        stalenessOf(webElement, IWaitTimes.TEN_SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public void clickToBeSelectedWebElementWithJS(WebElement webElement) {
        elementToBeSelected(webElement, IWaitTimes.TEN_SECONDS);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public void clickVisibleWebElementWithJS(WebElement webElement) {
        visibilityOf(webElement, IWaitTimes.TEN_SECONDS);

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

    public static int convertStringToInt(String value) {
        return Integer.parseInt(value);
    }

    public static String convertStringFromUpperCaseToLowercase(String upperCaseString) {
        return upperCaseString.trim().toLowerCase();
    }

    public static String getProperty(String propertyFileName, String propertyName) {
        return PropertyReader
                .from(propertyFileName, propertyName)
                .getProperty(propertyName);
    }
}