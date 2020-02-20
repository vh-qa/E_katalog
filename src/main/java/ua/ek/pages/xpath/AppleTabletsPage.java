package ua.ek.pages.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.ek.base.BasePage;
import ua.ek.pages.tablets.TabletsManufacturerPage;

public class AppleTabletsPage extends BasePage {

    @FindBy(xpath = ".//*[@id=\"li_br116\"]/label") // Apple
    private WebElement manufacturerApple;

    // 'Показать' button
    @FindBy(xpath = ".//*[@id=\"tt-info\"]/a")
    private WebElement showButton;

    // Page title
    @FindBy(xpath=".//div[@class='page-title']/h1[@class='t2' and contains(text(), 'Apple')]")
    private WebElement pageTitle;

    // Выбор названий всех планшетов на странице
    @FindBy(xpath = ".//td/a[@class='model-short-title no-u']")
    private WebElement allTabletsTitlesOnPage;

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
