package ua.ek.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final static int FIVE_SECONDS = 5;
    protected final static int TEN_SECONDS = 10;
    protected final static int FIFTEEN_SECONDS = 15;
    protected final static int TWENTY_SECONDS = 20;

    protected final static Logger LOG = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;

    //  @FindBy(xpath = "//*[@id=\"mui_user_login_row\"]/span/em")
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

    // Get text from web element
    protected String getWebElementText(By by){
        return waitUntilElementIsVisible(FIVE_SECONDS, by).getText().trim();
/*
        if(isWebElementPresent(by)) {
            return driver.findElement(by).getText().trim();
        }else{
//            throw new RuntimeException();
            return "";
        }
 */
    }

    // Get text from web element
    protected String getWebElementText(WebElement webElement){
        return waitUntilElementIsVisible(FIVE_SECONDS, webElement).getText().trim();
    }

    // Enter text to text field
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

    // Waiting for web element appearance during waitTime
    protected WebElement waitUntilElementIsVisible(Integer waitTime, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.withMessage("Element was not found");

        return webElement;
    }

    // Waiting for web element appearance during waitTime
    protected WebElement waitUntilElementIsVisible(Integer waitTime, By by) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        WebElement webElement = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.withMessage("Element was not found");

        return webElement;
    }

    protected void presenceOfElementLocated(Integer waitTime, WebElement webElement, By by) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        webElement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
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

    // Click on web element by xpath
    protected void clickWebElementByXpath(String xpath) {
        driver
                .findElement(By.xpath(xpath))
                .click();
    }

    protected void executeWebElement(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    // Verify if web element is present
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
