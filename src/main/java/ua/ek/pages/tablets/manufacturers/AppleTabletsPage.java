package ua.ek.pages.tablets.manufacturers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

public class AppleTabletsPage extends BasePage {

    @FindBy(xpath = ".//label[@title='id: 116']")
    private WebElement manufacturerApple;

    @FindBy(xpath = ".//td[@id='tt-info']/a[@class='show-models']")
    private WebElement showButton;

    @FindBy(xpath = ".//div[@class='page-title']/h1")
    private WebElement pageTitle;

    private String pageTitleXpath = ".//div[@class='page-title']/h1";

    public AppleTabletsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAppleManufacturerCheckBox() {
        return manufacturerApple;
    }

    public WebElement getShowButton() {
        return showButton;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public String getPageTitleXpath() {
        return pageTitleXpath;
    }
}