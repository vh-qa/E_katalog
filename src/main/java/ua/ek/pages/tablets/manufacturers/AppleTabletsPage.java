package ua.ek.pages.tablets.manufacturers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;

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
