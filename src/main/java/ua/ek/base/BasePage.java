package ua.ek.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ek.utils.ITimeOfWait;

public abstract class BasePage {

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
        if(isWebElementPresent(by)) {
            return driver.findElement(by).getText().trim();
        }else {
            return "";
        }
    }

    // Get text from web element
    protected String getWebElementText(WebElement webElement){
       return webElement.getText().trim();
    }

    // Enter text to text field
    protected void enterTextInTextField(WebElement textField, String inputText) {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, textField);
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }

    protected void clickWebElement(WebElement webElement){
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, webElement);
        webElement.click();
    }

    // Waiting for web element appearance during waitTime
    protected void waitUntilElementIsVisible(Integer waitTime, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        wait.withMessage("Element was not found");
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
