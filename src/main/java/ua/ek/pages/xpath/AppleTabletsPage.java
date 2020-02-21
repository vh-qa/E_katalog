package ua.ek.pages.xpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class AppleTabletsPage extends BasePage {

    @FindBy(xpath = ".//*[@id=\"li_br116\"]/label")
    private WebElement manufacturerApple;

    @FindBy(xpath = ".//*[@id=\"tt-info\"]/a")
    private WebElement showButton;

    @FindBy(xpath=".//div[@class='page-title']/h1[@class='t2' and contains(text(), 'Apple')]")
    private WebElement pageTitle;

    public AppleTabletsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAppleManufacturerCheckBox(){
        return manufacturerApple;
    }

    public AppleTabletsPage clickShowButton() {
        waitUntilElementIsVisible(FIVE_SECONDS, showButton);
        executeWebElement(showButton);

        return new AppleTabletsPage(driver);
    }

    public String getPageTitleText(){
        return getWebElementText(pageTitle);
    }
}