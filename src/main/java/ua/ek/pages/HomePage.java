package ua.ek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.ek.base.BasePage;
import ua.ek.pages.registration.AuthPage;
import ua.ek.pages.tablets.TabletPage;
import ua.ek.pages.tablets.TabletsPage;
import ua.ek.pages.xpath.AppleTabletsPage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

//  @FindBy(xpath = ".//li[@class='mainmenu-item']/a[contains(@class,'mainmenu-link') and text()='Компьютеры']")
    @FindBy(xpath = ".//span[contains(@class,'mainmenu-link-helper')]")
    private WebElement computersLink; // Menu "Компьютеры"

    @FindBy(xpath = ".//a[contains(@class,'mainmenu-subitem mainmenu-icon30')]")
    private WebElement tabletsLink; // SubMenu "Планшеты"

    @FindBy(xpath = ".//*[@id=\"li_br116\"]/label") // Apple
    private WebElement manufacturerApple;

    public AuthPage clickEnterLink() {
        if (getEnterLink() != null) {
            clickWebElement(getEnterLink());
            return new AuthPage(driver);
        }
        return null;
    }

    public TabletsPage clickTabletsLink() {
        clickWebElement(computersLink);
        clickWebElement(tabletsLink);

        return new TabletsPage(driver);
    }

    public TabletPage clickTabletLink() {
        clickWebElement(computersLink);
        clickWebElement(tabletsLink);

        return new TabletPage(driver);
    }

    public AppleTabletsPage clickAppleTabletsCheckBox(){
        clickWebElement(computersLink);
        clickWebElement(tabletsLink);

        waitUntilElementIsVisible(FIVE_SECONDS, manufacturerApple);
        executeWebElement(manufacturerApple);

        return new AppleTabletsPage(driver);
    }

    public WebElement getWebElement(WebElement webElement){
        return webElement;
    }
}
