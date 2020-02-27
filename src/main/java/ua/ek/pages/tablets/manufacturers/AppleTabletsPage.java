package ua.ek.pages.tablets.manufacturers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ek.base.BasePage;
import ua.ek.utils.CustomWaits;

public class AppleTabletsPage extends BasePage {

    @FindBy(xpath = ".//*[@id='li_br116']/label")
    private WebElement manufacturerApple;

    @FindBy(xpath = ".//*[@id='tt-info']/a")
    private WebElement showButton;

    //  @FindBy(xpath = ".//div[@class='page-title']/h1[@class='t2' and contains(text(), '%s')]")
    @FindBy(xpath = ".//div[@class='page-title']/h1")
    private WebElement pageTitle;

    private String pageTitleXpath = ".//div[@class='page-title']/h1";

    public AppleTabletsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAppleManufacturerCheckBox() {
        return manufacturerApple;
    }

    public AppleTabletsPage clickShowButton() {

        // Explicit wait
        elementToBeClickable(TEN_SECONDS, showButton);
        clickElementWithJS(showButton);

        return new AppleTabletsPage(driver);
    }

    public String getPageTitleText() {

        // Fluent wait
        WebElement webElementFluentWay = fluentWait(By.xpath(pageTitleXpath), FIVE_SECONDS, MILLISECOND_500);

        // Custom wait
        WebElement webElementCustomWait = waitUntilElementIsVisible(FIVE_SECONDS, By.xpath(pageTitleXpath));
        WebDriverWait wait = new WebDriverWait(driver, FIVE_SECONDS);
        wait.until(CustomWaits.isElementContainsText(webElementCustomWait, "Apple"));

        return webElementCustomWait.getText();
    }
}