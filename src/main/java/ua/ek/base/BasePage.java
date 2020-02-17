package ua.ek.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ek.utils.ITimeOfWait;

public abstract class BasePage {

    public static String BASE_URL = "";
    protected WebDriver driver;

    //  @FindBy(xpath = "//*[@id=\"mui_user_login_row\"]/span/em")
    @FindBy(xpath = "//span[@class='wu_entr']//em")
    private WebElement enterLink; // "Войти" link

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEnterLink() {
        if (isWebElementDisplayed(enterLink)) {
            return enterLink;
        }
        return null;
    }


    // Get text from web element
    public static String getWebElementText(WebElement webElement){
        return webElement.getText().trim();
    }


    // Enter text to text field
    public void enterTextInTextField(WebElement textField, String inputText) {
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, textField);
        textField.click();
        textField.clear();
        textField.sendKeys(inputText);
    }


    public void clickWebElement(WebElement webElement){
        waitUntilElementIsVisible(ITimeOfWait.FIVE_SECONDS, webElement);
        webElement.click();
    }


    // Waiting for web element appearance during waitTime
    protected void waitUntilElementIsVisible(Integer waitTime, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(webElement));
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
}
